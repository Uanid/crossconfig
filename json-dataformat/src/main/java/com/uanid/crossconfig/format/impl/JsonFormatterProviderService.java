package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.*;

/**
 * @author uanid
 * @since 2019-06-15
 */
public class JsonFormatterProviderService implements FormatterProviderService {

    @Override
    public FormatterFactory getFormatterFactory() {
        return JsonFormatterFactory.getInstance();
    }

}