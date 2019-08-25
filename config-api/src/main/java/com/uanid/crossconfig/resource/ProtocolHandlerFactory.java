package com.uanid.crossconfig.resource;

/**
 * @author uanid
 * @since 2019-07-07
 */
public interface ProtocolHandlerFactory {

    ProtocolHandler newInstance();

    ProtocolType getProtocolHandlerType();
}
