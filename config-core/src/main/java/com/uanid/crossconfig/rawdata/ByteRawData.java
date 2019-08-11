package com.uanid.crossconfig.rawdata;

import java.nio.ByteBuffer;

public class ByteRawData implements RawData<ByteBuffer> {
    private static final RawDataType RAW_DATA_TYPE = new RawDataType("ByteData", ByteBuffer.class);

    private ByteBuffer byteBuffer;

    public ByteRawData(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    public ByteRawData(byte[] bytes) {
        this.byteBuffer = ByteBuffer.wrap(bytes);
    }

    @Override
    public ByteBuffer getData() {
        return byteBuffer;
    }

    @Override
    public RawDataType getRawDataType() {
        return RAW_DATA_TYPE;
    }

    @Override
    public byte[] toByteArray() {
        return byteBuffer.array();
    }
}
