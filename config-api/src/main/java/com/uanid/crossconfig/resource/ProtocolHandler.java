package com.uanid.crossconfig.resource;

import com.uanid.crossconfig.exception.RuntimeConfigException;
import com.uanid.crossconfig.rawdata.RawData;

/**
 * @author uanid
 * @since 2019-08-17
 */
public interface ProtocolHandler {
    
    //method responsibility: flow control method
    RawData load(ResourceUri resourceUri) throws RuntimeConfigException;

    //method responsibility: flow control method
    void save(ResourceUri resourceUri, RawData rawData) throws RuntimeConfigException;

    ProtocolType getProtocolType();
}
