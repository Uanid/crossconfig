package com.uanid.crossconfig.format;

import com.uanid.crossconfig.common.CachedRepository;
import com.uanid.crossconfig.util.MatchType;

import java.util.ArrayList;
import java.util.ServiceLoader;

/**
 * @author uanid
 * @since 2019-05-19
 */
public final class FormatterManager {
    private static final String DEFAULT_FORMATTER_NAME = "DefaultSnakeYAML";

    public static FormatterManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private CachedRepository<FormatterProviderService> repository;

    private FormatterManager() {
        this.repository = new CachedRepository<>(new ArrayList<>(), new CachedRepository.MatchFunction<>(this::compareFunction));
        this.initRegisterFormatter();
    }

    private MatchType compareFunction(String keyword, FormatterProviderService formatterProvider) {
        FormatterType type = formatterProvider.getFormatterType();
        return MatchType.compareToMatchType(keyword, type.getName(), type.getAlias());
    }

    private void initRegisterFormatter() {
        ServiceLoader<FormatterProviderService> services = ServiceLoader.load(FormatterProviderService.class);
        for (FormatterProviderService service : services) {
            this.registerFormatter(service);
        }
    }

    public synchronized void registerFormatter(FormatterProviderService provider) {
        repository.registerItem(provider);
    }

    public FormatterProviderService getFormatterProvider() {
        return this.getFormatterProvider(DEFAULT_FORMATTER_NAME, false);
    }

    public FormatterProviderService getFormatterProvider(String formatterName) {
        return this.getFormatterProvider(formatterName, true);
    }

    //implicitlyMatch : 암시적 매칭 사용 여부
    public synchronized FormatterProviderService getFormatterProvider(String formatterName, boolean implicitlyMatch) {
        MatchType atLeastMatchType = implicitlyMatch ? MatchType.ALIAS : MatchType.PRIMARY;
        return repository.searchItem(formatterName, atLeastMatchType);
    }

    private static class SingletonHolder {
        private static FormatterManager INSTANCE = new FormatterManager();
    }
}
