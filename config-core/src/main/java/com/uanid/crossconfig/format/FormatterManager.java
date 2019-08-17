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

    private CachedRepository<FormatterFactory> repository;

    private FormatterManager() {
        this.repository = new CachedRepository<>(new ArrayList<>(), new CachedRepository.MatchFunction<>(this::compareFunction));
        this.initRegisterFormatter();
    }

    private MatchType compareFunction(String keyword, FormatterFactory factory) {
        FormatterType type = factory.getFormatterType();
        return MatchType.compareToMatchType(keyword, type.getName(), type.getAlias());
    }

    private void initRegisterFormatter() {
        ServiceLoader<FormatterProviderService> services = ServiceLoader.load(FormatterProviderService.class);
        for (FormatterProviderService service : services) {
            this.registerFormatterFactory(service.getFormatterFactory());
        }
    }

    public synchronized void registerFormatterFactory(FormatterFactory provider) {
        repository.registerItem(provider);
    }

    public Formatter getFormatter() {
        return this.getFormatter(DEFAULT_FORMATTER_NAME, false);
    }

    public Formatter getFormatter(String formatterName) {
        return this.getFormatter(formatterName, true);
    }

    //implicitlyMatch : 암시적 매칭 사용 여부
    public synchronized Formatter getFormatter(String formatterName, boolean implicitlyMatch) {
        MatchType atLeastMatchType = implicitlyMatch ? MatchType.ALIAS : MatchType.PRIMARY;
        return repository.searchItem(formatterName, atLeastMatchType).newInstance();
    }

    private static class SingletonHolder {
        private static FormatterManager INSTANCE = new FormatterManager();
    }
}
