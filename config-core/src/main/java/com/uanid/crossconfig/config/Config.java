package com.uanid.crossconfig.config;

import com.uanid.crossconfig.resource.ResourceAccessor;

public interface Config {

    boolean isLoaded();

    void loadConfig();

    void loadConfig(ResourceAccessor resourceAccessor);

    void saveConfig();

    void saveConfig(ResourceAccessor resourceAccessor);

    void clearConfig();

    Object getValue(String key);

    void setValue(String key, Object value);
}
