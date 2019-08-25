package com.uanid.crossconfig.resource;

import com.uanid.crossconfig.exception.RuntimeConfigException;
import com.uanid.crossconfig.rawdata.RawData;
import com.uanid.crossconfig.util.Validate;

/**
 * @author uanid
 * @since 2019-07-07
 */
public abstract class DefaultProtocolHandler implements ProtocolHandler {

    private ProtocolType protocolType;

    public DefaultProtocolHandler(ProtocolType protocolType) {
        this.protocolType = protocolType;
    }

    //method responsibility: flow control method
    @Override
    public RawData load(ResourceUri resourceUri) throws RuntimeConfigException {
        try {
            Validate.trueIs(protocolType.isLoadable());
            return loadProcess(resourceUri);
        } catch (Exception e) {
            throw new RuntimeConfigException(e);
        }
    }

    //method responsibility: flow control method
    @Override
    public void save(ResourceUri resourceUri, RawData rawData) throws RuntimeConfigException {
        try {
            Validate.trueIs(protocolType.isSavable());
            saveProcess(resourceUri, rawData);
        } catch (Exception e) {
            throw new RuntimeConfigException(e);
        }
    }

    protected abstract RawData loadProcess(ResourceUri resourceUri) throws Exception;

    protected abstract void saveProcess(ResourceUri resourceUri, RawData rawData) throws Exception;

    @Override
    public ProtocolType getProtocolType() {
        return protocolType;
    }
}
