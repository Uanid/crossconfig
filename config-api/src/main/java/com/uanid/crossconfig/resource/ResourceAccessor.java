package com.uanid.crossconfig.resource;

import com.uanid.crossconfig.rawdata.RawData;

/**
 * @author uanid
 * @since 2019-07-07
 */
public interface ResourceAccessor {
    ResourceUri getResourceUri();

    RawData load();

    void save(RawData data);

    void saveManually(ResourceUri resourceUri, RawData data);

    ProtocolType getProtocolType();
}
