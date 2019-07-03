package com.uanid.crossconfig.resource;

import com.uanid.crossconfig.rawdata.RawData;

public interface ResourceAccessor {
    ResourceUri getResourceUri();

    RawData load();

    RawData save();

    RawData saveManually(ResourceUri resourceUri);

    ProtocolType getProtocolType();
}
