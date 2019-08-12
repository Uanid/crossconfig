package com.uanid.crossconfig.format;

import com.uanid.crossconfig.exception.DuplicatedKeyException;
import com.uanid.crossconfig.exception.RuntimeConfigException;
import com.uanid.crossconfig.util.MatchType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author uanid
 * @since 2019-05-19
 */
public final class FormatterManager {
    private static final String DEFAULT_FORMATTER_NAME = "DefaultSnakeYAML";

    private static class SingletonHolder {
        private static FormatterManager INSTANCE = new FormatterManager();
    }

    public static FormatterManager getInstance() {
        return SingletonHolder.INSTANCE;
    }


    private List<FormatterProviderService> providerContainer;
    private Map<String, FormatterProviderService> cachedProviderContainer;

    private FormatterManager() {
        this.providerContainer = new ArrayList<>();
        this.cachedProviderContainer = new HashMap<>();
        this.initRegisterFactory();
    }

    private void initRegisterFactory() {

    }

    public void registerFactory(FormatterProviderService provider) {
        FormatterProviderService result = this.findProvider(provider.getFormatterType());
        if (result == null) {
            this.cachedProviderContainer.clear();
            this.providerContainer.add(provider);
        } else {
            throw new DuplicatedKeyException();
        }
    }

    private FormatterProviderService findProvider(FormatterType formatterType) {
        for (FormatterProviderService provider : providerContainer) {
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
    private FormatterProviderService findProvider(String formatterName, boolean isImplicty) {
        FormatterProviderService ff = getCachedProvider(formatterName);
        if (ff != null) {
            return ff;
        }

        ff = lookup(formatterName, isImplicty);
        if (ff != null) {
            this.cacheFactory(formatterName, ff);
        }
        return ff;
    }

    private FormatterProviderService getCachedProvider(String formatterName) {
        return cachedProviderContainer.get(formatterName);
    }

    private void cacheFactory(String formatterName, FormatterProviderService formatterProviderService) {
        this.cachedProviderContainer.put(formatterName, formatterProviderService);
    }

    private FormatterProviderService lookup(String formatterName, boolean implicitlyMatch) {
        FormatterProviderService formatterProviderService = null;
        for (FormatterProviderService provider : providerContainer) {
            MatchType matchType = provider.getFormatterType().compareToMatchType(formatterName, implicitlyMatch);

            if (matchType == MatchType.PRIMARY) {
                formatterProviderService = provider;
                break;
            } else if (matchType == MatchType.ALIAS) {
                formatterProviderService = provider;
            }
        }

        return formatterProviderService;
    }

    public FormatterProviderService getFormatterProvider() {
        return this.getFormatterProvider(DEFAULT_FORMATTER_NAME, false);
    }

    public FormatterProviderService getFormatterProvider(String formatterName) {
        return this.getFormatterProvider(formatterName, true);
    }

    public FormatterProviderService getFormatterProvider(String formatterName, boolean implicitlyMatch) {
        FormatterProviderService provider = this.findProvider(formatterName, implicitlyMatch);
        if (provider == null) {
            throw new RuntimeConfigException("targetFormatterName: " + formatterName);
        } else {
            return provider;
        }
    }
}
