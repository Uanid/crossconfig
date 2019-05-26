package com.uanid.crossconfig.resource;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class UrlTest {

    @Test
    public void protocol_factory_test() {
        URL.setURLStreamHandlerFactory(new URLStreamHandlerFactory() {
            @Override
            public URLStreamHandler createURLStreamHandler(String protocol) {
                return null;
            }
        });
        //System.out.println("완료");
    }

    @Test
    public void url_string_test() throws MalformedURLException {
        URL url = new URL("http", "myhost", "aa");
        //System.out.println(url.toString());

        Assert.assertEquals(new URL("http://myhost").getAuthority(), "myhost");
    }

    @Test
    public void protocols_test() throws IOException, URISyntaxException {
        URI url = new URI("jdbc://localhost:3306/ncm?useUnicode=true&characterEncoding=utf8#aa");

        System.out.println(url.getScheme());
        System.out.println(url.getSchemeSpecificPart());
        System.out.println(url.getUserInfo() == null);
        System.out.println(url.getAuthority());
        //System.out.println(url.getContent());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getQuery());
        System.out.println(url.getFragment());
        System.out.println(url.getUserInfo());
        System.out.println(url.getClass().getCanonicalName());
    }

    @Test
    public void procotolHandlerList(){
        "sun.net.www.protocol".toLowerCase();
        System.out.println(System.getProperty("java.protocol.handler.pkgs"));
    }
}
