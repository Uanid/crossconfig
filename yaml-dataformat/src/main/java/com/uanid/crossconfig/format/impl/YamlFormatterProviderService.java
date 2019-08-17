package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.*;

public class YamlFormatterProviderService implements FormatterProviderService {

    @Override
    public FormatterFactory getFormatterFactory() {
        return YamlFormatterFactory.getInstance();
    }
}
