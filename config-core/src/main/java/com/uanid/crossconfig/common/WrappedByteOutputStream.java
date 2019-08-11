package com.uanid.crossconfig.common;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author uanid
 * @since 2019-07-03
 */
public class WrappedByteOutputStream extends OutputStream {

    private FlexibleByteArray byteArray;

    public WrappedByteOutputStream() {
        this.byteArray = new FlexibleByteArray();
    }

    public WrappedByteOutputStream(int byteArraySize, int byteArrayGrowSize) {
        this.byteArray = new FlexibleByteArray(byteArraySize, byteArrayGrowSize);
    }

    public WrappedByteOutputStream(FlexibleByteArray byteArray){
        this.byteArray = byteArray;
    }

    @Override
    public void write(int b) throws IOException {
        byteArray.append((byte) b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        byteArray.append(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        byteArray.append(b, off, len);
    }

    @Override
    public void close() throws IOException {
        byteArray = null;
    }

    public byte[] toByteArray(){
        return byteArray.toByteArray();
    }
}
