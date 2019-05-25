package com.uanid.crossconfig.rawdata;

public class ByteRawData implements RawData<Byte[]> {
    private static final RawDataType RAW_DATA_TYPE = new RawDataType("ByteData", Byte.class);


    @Override
    public Byte[] getData() {
        return null;
    }

    @Override
    public String getMimeType() {
        return null;
    }

    @Override
    public String getExtension() {
        return null;
    }

    @Override
    public RawDataType getRawDataType() {
        return RAW_DATA_TYPE;
    }
}
