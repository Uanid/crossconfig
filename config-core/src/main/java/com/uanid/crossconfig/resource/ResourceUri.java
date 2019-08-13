package com.uanid.crossconfig.resource;

import com.uanid.crossconfig.util.Validate;

/**
 * @author uanid
 * @since 2019-06-21
 *
 * 멤버 변수들은 전부 null을 허용하지 않음
 */
public class ResourceUri {

    private String protocol;

    //선택적
    private String id;

    //선택적
    private String pw;

    //선택적
    private String host;

    //선택적
    private int port;

    private String path;

    //선택적
    private String query;

    //선택적
    private String fragment;

    private String fullUri;

    public ResourceUri(String protocol, String id, String pw, String host, int port, String path, String query, String fragment) {
        this.protocol = StringUtils.withoutNull(protocol);
        this.id = StringUtils.withoutNull(id);
        this.pw = StringUtils.withoutNull(pw);
        this.host = StringUtils.withoutNull(host);

        Validate.betweenAnB(0, port, 65535);
        this.port = port;
        this.path = StringUtils.withoutNull(path);
        this.query = StringUtils.withoutNull(query);
        this.fragment = StringUtils.withoutNull(fragment);
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

    public boolean hasId() {
        return !id.equals("");
    }

    public boolean hasPw() {
        return !pw.equals("");
    }

    public boolean hasHost() {
        return !host.equals("");
    }

    public boolean hasPort() {
        return port != 0;
    }

    public boolean hasQuery() {
        return !query.equals("");
    }

    public boolean hasFragment() {
        return !fragment.equals("");
    }

    public String getUri() {
        if (fullUri == null) {
            fullUri = createFullUri();
        }
        return fullUri;
    }

    /**
     * 입력한 인자로 덮어씌워서 클론을 만들어 주는 메서드
     * null 또는 0(zero) 입력시 덮어씌우지 않음
     * 값을 지우려면 "" (0칸 문자열)을 입력하면 됨
     */
    public ResourceUri overridedClone(String protocol, String id, String pw, String host, int port, String path, String query, String fragment) {
        ResourceUri clone = this.clone();
        if(protocol != null) clone.protocol = protocol;
        if(id != null) clone.id = id;
        if(pw != null) clone.pw = pw;
        if(host != null) clone.host = host;
        if(port != 0) clone.port = port;
        if(path != null) clone.path = path;
        if(query != null) clone.query = query;
        if(fragment != null) clone.fragment = fragment;
        return clone;
    }

    public ResourceUri clone(){
        return new ResourceUri(protocol, id, pw, host, port, path, query, fragment);
    }

    private String createFullUri() {
        return protocol + "://" +
                id +
                (hasPw() ? ":" : "") + pw +
                (hasId() ? "@" : "") +
                host +
                path +
                (hasQuery() ? "?" : "") + query +
                (hasFragment() ? "#" : "") + fragment;
    }

    @Override
    public String toString() {
        return "ResourceUri{" +
                "impl='" + protocol + '\'' +
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
