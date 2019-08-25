package com.uanid.crossconfig.resource.impl;

import com.uanid.crossconfig.resource.ProtocolHandler;
import com.uanid.crossconfig.resource.ProtocolHandlerFactory;
import com.uanid.crossconfig.resource.ProtocolType;

public class HttpHandlerFactory implements ProtocolHandlerFactory {
    private static final ProtocolType PROTOCOL_TYPE = new ProtocolType("HTTP", "1.1");

    private HttpHandlerFactory() {
    }

    public static HttpHandlerFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public ProtocolHandler newInstance() {
        return new HttpHandler(PROTOCOL_TYPE);
    }

    @Override
    public ProtocolType getProtocolHandlerType() {
        return PROTOCOL_TYPE;
    }

    private static class SingletonHolder {
        private static final HttpHandlerFactory INSTANCE = new HttpHandlerFactory();
    }
}
