package com.uanid.crossconfig.resource;

import com.uanid.crossconfig.rawdata.RawData;

public abstract class ProtocolHandler {

    private ProtocolType protocolType;
    private ResourceUri resourceUri;

    public ProtocolHandler(ProtocolType protocolType, ResourceUri resourceUri) {
        this.protocolType = protocolType;
    }

    public RawData load(ResourceUri resourceUri) throws LoadFailException {
        try {
            return load0(resourceUri);
        } catch (Exception e) {
            throw new LoadFailException(e);
        }
    }

    public void save(ResourceUri resourceUri, RawData rawData) throws SaveFailException {
        try {
            save0(resourceUri, rawData);
        } catch (Exception e) {
            throw new SaveFailException(e);
        }
    }

    protected abstract RawData load0(ResourceUri resourceUri) throws Exception;

    protected abstract void save0(ResourceUri resourceUri, RawData rawData) throws Exception;

    public ProtocolType getProtocolType() {
        return protocolType;
    }
}
