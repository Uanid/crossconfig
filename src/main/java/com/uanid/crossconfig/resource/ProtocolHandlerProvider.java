package com.uanid.crossconfig.resource;

public interface ProtocolHandlerProvider {

    ProtocolHandler getProtocolHandler();

    ProtocolType getProtocolHandlerReturnType();
}
