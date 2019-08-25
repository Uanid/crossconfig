package com.uanid.crossconfig.resource.impl;

import com.uanid.crossconfig.rawdata.ByteRawData;
import com.uanid.crossconfig.rawdata.RawData;
import com.uanid.crossconfig.resource.DefaultProtocolHandler;
import com.uanid.crossconfig.resource.ProtocolType;
import com.uanid.crossconfig.resource.ResourceUri;
import com.uanid.crossconfig.util.CommonUtils;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;

/**
 * @author uanid
 * @since 2019-06-25
 */
public class HttpHandler extends DefaultProtocolHandler {

    public HttpHandler(ProtocolType protocolType) {
        super(protocolType);
    }

    @Override
    protected RawData loadProcess(ResourceUri resourceUri) throws Exception {
        HttpURLConnection httpURLConnection = this.createConnection(resourceUri);
        setHeaderForConnection(httpURLConnection, resourceUri);
        byte[] data = loadDataByConnection(httpURLConnection);
        return new ByteRawData(data);
    }
    
    @Override
    protected void saveProcess(ResourceUri resourceUri, RawData rawData) throws Exception {
        HttpURLConnection httpURLConnection = this.createConnection(resourceUri);
        setHeaderForConnection(httpURLConnection, resourceUri);
        writeDataToConnection(httpURLConnection, rawData.toByteArray());
    }

    private HttpURLConnection createConnection(ResourceUri resourceUri) throws IOException {
        ResourceUri idPwNulledResourceUri = resourceUri.overridedClone(null, "", "", null, 0, null, null, null);
        URL url = new URL(idPwNulledResourceUri.getUri());
        return (HttpURLConnection) url.openConnection();
    }

    private void setHeaderForConnection(HttpURLConnection httpURLConnection, ResourceUri resourceUri) {
        boolean hasAuthenticateInfo = resourceUri.hasId() || resourceUri.hasPw();
        if (hasAuthenticateInfo) {
            String idPw = resourceUri.getId() + ":" + resourceUri.getPw();
            String authenticateValue = String.format("%s %s", "BASIC", Base64.getEncoder().encodeToString(idPw.getBytes()));
            httpURLConnection.setAuthenticationProperty("www-authenticate", authenticateValue);
        }
    }

    private byte[] loadDataByConnection(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.connect();
        InputStream sourceStream = httpURLConnection.getInputStream();
        byte[] data = CommonUtils.toByteArray(sourceStream);
        httpURLConnection.disconnect();
        return data;
    }

    private void writeDataToConnection(HttpURLConnection httpURLConnection, byte[] data) throws IOException {
        httpURLConnection.connect();
        BufferedOutputStream bos = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bos.write(data);
        bos.close();
        httpURLConnection.disconnect();
    }
}
