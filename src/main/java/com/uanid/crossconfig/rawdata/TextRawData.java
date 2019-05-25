package com.uanid.crossconfig.rawdata;

public class TextRawData implements RawData<CharSequence> {
    private static final RawDataType RAW_DATA_TYPE = new RawDataType("TextData", CharSequence.class);

    @Override
    public CharSequence getData() {
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
