package com.uanid.crossconfig.format;

import com.uanid.crossconfig.exception.DuplicatedKeyException;
import com.uanid.crossconfig.format.impl.IniFormatterProvider;
import com.uanid.crossconfig.format.impl.JsonFormatterProvider;
import com.uanid.crossconfig.format.impl.YamlFormatterProvider;
import com.uanid.crossconfig.util.MatchType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author uanid
 * @since 2019-05-19
 */
public final class FormatterFactory {
    private static final String DEFAULT_FORMATTER_NAME = "DefaultSnakeYAML";

    private static class SingletonHolder {
        private static FormatterFactory INSTANCE = new FormatterFactory();
    }

    public static FormatterFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }


    private List<FormatterProvider> providerContainer;
    private Map<String, FormatterProvider> cachedProviderContainer;

    private FormatterFactory() {
        this.providerContainer = new ArrayList<>();
        this.cachedProviderContainer = new HashMap<>();
        this.initRegisterFactory();
    }

    private void initRegisterFactory() {
        this.registerFactory(YamlFormatterProvider.getInstance());
        this.registerFactory(JsonFormatterProvider.getInstance());
        this.registerFactory(IniFormatterProvider.getInstance());
    }

    public void registerFactory(FormatterProvider provider) {
        FormatterProvider result = this.findProvider(provider.getFormatterType());
        if (result == null) {
            this.cachedProviderContainer.clear();
            this.providerContainer.add(provider);
        } else {
            throw new DuplicatedKeyException();
        }
    }

    private FormatterProvider findProvider(FormatterType formatterType) {
        for (FormatterProvider provider : providerContainer) {
            if (provider.getFormatterType().equals(formatterType)) {
                return provider;
            }
        }
        return null;
    }

    /**
     * factoryContainer에서 accessorName에 해당하는 factory가 있는지 검사하는 메서드
     * implicty가 true일 경우, 설렁설렁 대소문자나 기타 규칙들을 무시하며 찾습니다.
     *
     * @param formatterName 찾길 원하는 accessor의 이름
     * @param isImplicty    이름을 암묵적으로 대소문자등을 무시하며 찾을 것인가, 명시적으로 정해진 것만 찾을 것인가
     * @return
     */
    private FormatterProvider findProvider(String formatterName, boolean isImplicty) {
        FormatterProvider ff = getCachedProvider(formatterName);
        if (ff != null) {
            return ff;
        }

        ff = lookup(formatterName, isImplicty);
        if (ff != null) {
            this.cacheFactory(formatterName, ff);
        }
        return ff;
    }

    private FormatterProvider getCachedProvider(String formatterName) {
        return cachedProviderContainer.get(formatterName);
    }

    private void cacheFactory(String formatterName, FormatterProvider formatterProvider) {
        this.cachedProviderContainer.put(formatterName, formatterProvider);
    }

    private FormatterProvider lookup(String formatterName, boolean implicitlyMatch) {
        FormatterProvider formatterProvider = null;
        for (FormatterProvider provider : providerContainer) {
            MatchType matchType = provider.getFormatterType().matchType(formatterName, implicitlyMatch);

            if (matchType == MatchType.PRIMARY) {
                formatterProvider = provider;
                break;
            } else if (matchType == MatchType.ALIAS) {
                formatterProvider = provider;
            }
        }

        return formatterProvider;
    }

    public FormatterProvider getFormatterProvider() {
        return this.getFormatterProvider(DEFAULT_FORMATTER_NAME, false);
    }

    public FormatterProvider getFormatterProvider(String formatterName) {
        return this.getFormatterProvider(formatterName, true);
    }

    public FormatterProvider getFormatterProvider(String formatterName, boolean implicitlyMatch) {
        FormatterProvider provider = this.findProvider(formatterName, implicitlyMatch);
        if (provider == null) {
            throw new CannotFindFormatterException("targetFormatterName: " + formatterName);
        } else {
            return provider;
        }
    }
}
