package com.uanid.crossconfig.format;

import com.uanid.crossconfig.format.impl.YamlFormatterFactory;
import com.uanid.crossconfig.exception.DuplicatedKeyException;
import com.uanid.crossconfig.util.CommonUtils;

import java.util.*;

/**
 * @author uanid
 * @since 2019-05-19
 */
public final class FormatterFactoryUtil {

    private static class SingletonHolder {
        private static FormatterFactoryUtil INSTANCE = new FormatterFactoryUtil();
    }

    private static final String DEFAULT_FORMATTER_NAME = "DefaultSnakeYAML";

    public static FormatterFactoryUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private List<FormatterFactory> factories;
    private Map<String, FormatterFactory> cachedFactories;

    private FormatterFactoryUtil() {
        this.factories = new ArrayList<>();
        this.cachedFactories = new HashMap<>();
        this.initRegisterFactory();
    }

    private void initRegisterFactory() {
        this.registerFactory(YamlFormatterFactory.getInstance());
    }

    public void registerFactory(FormatterFactory factory) {
        FormatterFactory result = this.findAccessorFactory(factory.getFormatterName(), false);
        if (result == null) {
            this.cachedFactories.clear();
            this.factories.add(factory);
        } else {
            throw new DuplicatedKeyException();
        }
    }

    /**
     * factoryContainer에서 accessorName에 해당하는 factory가 있는지 검사하는 메서드
     * implicty가 true일 경우, 설렁설렁 대소문자나 기타 규칙들을 무시하며 찾습니다.
     *
     * @param formatterName 찾길 원하는 accessor의 이름
     * @param isImplicty   이름을 암묵적으로 대소문자등을 무시하며 찾을 것인가, 명시적으로 정해진 것만 찾을 것인가
     * @return
     */
    private FormatterFactory findAccessorFactory(String formatterName, boolean isImplicty) {
        if (cachedFactories.containsKey(formatterName)) {
            return cachedFactories.get(formatterName);
        }

        FormatterFactory formatterFactory = null;
        for (FormatterFactory factory : factories) {
            String name = factory.getFormatterName();
            List<String> alias = factory.getFormatterAlias();

            CommonUtils.MatchType matchType = CommonUtils.matchNames(name, alias, formatterName);

            //암시적인 매칭까지 검사
            if (isImplicty) {
                String lowerName = name.toLowerCase();
                List<String> lowerAlias = new ArrayList<>();
                for (String s : alias) {
                    lowerAlias.add(s.toLowerCase());
                }

                CommonUtils.MatchType matchType2 = CommonUtils.matchNames(lowerName, lowerAlias, formatterName.toLowerCase());
                matchType = CommonUtils.MatchType.getUpperType(matchType, matchType2);
            }

            if (matchType == CommonUtils.MatchType.PRIMARY) {
                formatterFactory = factory;
                break;
            } else if (matchType == CommonUtils.MatchType.ALIAS) {
                formatterFactory = factory;
            }
        }

        if (formatterFactory != null) {
            this.cachedFactories.put(formatterName, formatterFactory);
        }
        return formatterFactory;
    }

    public FormatterFactory getFormatterFactory() {
        return this.getFormatterFactory(DEFAULT_FORMATTER_NAME, false);
    }

    public FormatterFactory getFormatterFactory(String formatterName) {
        return this.getFormatterFactory(formatterName, true);
    }

    public FormatterFactory getFormatterFactory(String formatterName, boolean isImplicty) {
        FormatterFactory accessor = this.findAccessorFactory(formatterName, isImplicty);
        if (accessor == null) {
            throw new CannotFindFormatterException("targetFormatterName: " + formatterName);
        } else {
            return accessor;
        }
    }
}
