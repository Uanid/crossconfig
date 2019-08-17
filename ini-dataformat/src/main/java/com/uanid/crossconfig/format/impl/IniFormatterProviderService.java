package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.*;

public class IniFormatterProviderService implements FormatterProviderService {

    @Override
    public FormatterFactory getFormatterFactory() {
        return IniFormatterFactory.getInstance();
    }
}
