package com.uanid.crossconfig.resource;

public class ResourceUri {
    private String protocol;
    private String id;
    private String pw;
    private String host;
    private int port;
    private String path;
    private String query;
    private String fragment;

    public ResourceUri(String protocol, String id, String pw, String host, int port, String path, String query, String fragment) {
        this.protocol = protocol;
        this.id = id;
        this.pw = pw;
        this.host = host;
        this.port = port;
        this.path = path;
        this.query = query;
        this.fragment = fragment;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }

    public String getQuery() {
        return query;
    }

    public String getFragment() {
        return fragment;
    }

    @Override
    public String toString() {
        return "ResourceUri{" +
                "protocol='" + protocol + '\'' +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", path='" + path + '\'' +
                ", query='" + query + '\'' +
                ", fragment='" + fragment + '\'' +
                '}';
    }
}
