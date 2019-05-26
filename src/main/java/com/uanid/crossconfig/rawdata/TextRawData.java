package com.uanid.crossconfig.rawdata;

public class TextRawData implements RawData<CharSequence> {
    private static final RawDataType RAW_DATA_TYPE = new RawDataType("TextData", CharSequence.class);

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
}
