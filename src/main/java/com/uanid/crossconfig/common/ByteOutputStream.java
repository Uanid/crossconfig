package com.uanid.crossconfig.common;

import java.io.IOException;
import java.io.OutputStream;

public class ByteOutputStream extends OutputStream {

    private FlexibleByteArray byteArray;

    public ByteOutputStream() {
        this.byteArray = new FlexibleByteArray();
    }

    public ByteOutputStream(int byteArraySize, int byteArrayGrowSize) {
        this.byteArray = new FlexibleByteArray(byteArraySize, byteArrayGrowSize);
    }

    public ByteOutputStream(FlexibleByteArray byteArray){
        this.byteArray = byteArray;
    }

    @Override
    public void write(int b) throws IOException {
        this.byteArray.append(new byte[]{(byte) b});
    }

    @Override
    public void close() throws IOException {
        byteArray = null;
    }

    public byte[] toByteArray(){
        return byteArray.toByteArray();
    }
}
