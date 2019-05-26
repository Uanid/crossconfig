package com.uanid.crossconfig.resource.protocol;

import com.uanid.crossconfig.rawdata.RawData;
import com.uanid.crossconfig.resource.ProtocolHandler;
import com.uanid.crossconfig.resource.ProtocolType;
import com.uanid.crossconfig.resource.ResourceUri;

public class HttpHandler extends ProtocolHandler {
    private static final ProtocolType PROTOCOL_TYPE = new ProtocolType("HTTP", "1.1");

    public HttpHandler() {
        super(PROTOCOL_TYPE);
    }

    @Override
    protected RawData load0(ResourceUri resourceUri) throws Exception {
        return null;
    }

    @Override
    protected void save0(ResourceUri resourceUri, RawData rawData) throws Exception {

    }
}
