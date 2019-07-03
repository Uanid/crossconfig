package com.uanid.crossconfig.rawdata;

import java.nio.charset.Charset;

public class TextRawData implements RawData<CharSequence> {
    public static final RawDataType RAW_DATA_TYPE = new RawDataType("TextData", CharSequence.class);

    private CharSequence charSequence;

    public TextRawData(CharSequence text) {
        this.charSequence = text;
    }

    @Override
    public CharSequence getData() {
        return charSequence;
    }

    @Override
    public RawDataType getRawDataType() {
        return RAW_DATA_TYPE;
    }

    @Override
    public byte[] toByteArray() {
        return charSequence.toString().getBytes(Charset.forName("UTF-8"));
    }
}
