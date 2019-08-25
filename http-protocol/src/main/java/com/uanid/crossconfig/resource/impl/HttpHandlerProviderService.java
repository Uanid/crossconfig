package com.uanid.crossconfig.resource.impl;

import com.uanid.crossconfig.resource.ProtocolHandlerFactory;
import com.uanid.crossconfig.resource.ProtocolHandlerProviderService;

/**
 * @author uanid
 * @since 2019-08-17
 */
public class HttpHandlerProviderService implements ProtocolHandlerProviderService {
    @Override
    public ProtocolHandlerFactory getProtocolHandlerFactory() {
        return HttpHandlerFactory.getInstance();
    }
}
