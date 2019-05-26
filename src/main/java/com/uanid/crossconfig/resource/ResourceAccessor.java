package com.uanid.crossconfig.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class ResourceAccessor {
    private static final String DEFAULT_PROTOCOL = "file";

    private ResourceUri resourceUri;
    private ProtocolHandler protocolHandler;

    /**
     * @param protocol scheme과 동치
     * @param userInfo id[:pw]
     * @param host     ipv4 | ipv6 | host-name
     * @param port     digit
     * @param path     [/path]*
     * @param query    ?key=value[&key=value]*
     * @param fragment #value
     */
    public ResourceAccessor(String protocol, String userInfo, String host, int port, String path, String query, String fragment) throws URISyntaxException {
        this(new URI(protocol, userInfo, host, port, path, query, fragment));
    }

    public ResourceAccessor(String protocol, String host, int port, String path) throws URISyntaxException {
        this(new URI(protocol, null, host, port, path, null, null));
    }

    public ResourceAccessor(String urlString) throws URISyntaxException {
        this(new URI(urlString));
    }

    public ResourceAccessor(URL url) throws URISyntaxException {
        this(url.toURI());
    }

    public ResourceAccessor(URI uri) {
        init(uri);
    }

    private void init(URI uri) {
        String userInfo = uri.getUserInfo();
        String id = null;
        String pw = null;
        if (userInfo != null && userInfo.contains(":")) {
            String[] args = userInfo.split(":");
            id = args[0];
            pw = args[1];
        }
        String protocol = uri.getScheme() != null ? uri.getScheme() : DEFAULT_PROTOCOL;
        resourceUri = new ResourceUri(protocol, id, pw, uri.getHost(), uri.getPort(), uri.getPath(), uri.getQuery(), uri.getFragment());
        //TODO: 프로토콜을 가져오는 기능을 만들어야 함
    }
}
