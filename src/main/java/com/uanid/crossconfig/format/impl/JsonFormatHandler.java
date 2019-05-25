package com.uanid.crossconfig.format.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uanid.crossconfig.format.DataFormatType;
import com.uanid.crossconfig.format.FormatHandler;
import com.uanid.crossconfig.node.ConfigNode;
import com.uanid.crossconfig.rawdata.RawData;

import java.io.IOException;

public class JsonFormatHandler extends FormatHandler {
    protected static final DataFormatType DATA_FORMAT_TYPE = new DataFormatType("Json", "RFC8259");
    private static final Class TARGET_RAW_DATA_CLASS = CharSequence.class;
    private ObjectMapper mapper;

    protected JsonFormatHandler() {
        super(DATA_FORMAT_TYPE);
        this.mapper = new ObjectMapper(new JsonFactory());
    }

    @Override
    public ConfigNode parse(RawData rawData) throws IOException {
        //TODO: 예상 flow 시나리오
        //1. rawdata가 내가 원하는 타입인지 검증
        //2. readTree로 JSONNODE로 가져옮
        //3. JSONNODE에서 CONFIGNODE로 변환
        //즉 이 handler는 flow관리자 역할을 하도록 만듦
        validateRawData(rawData);

        RawData<CharSequence> textRawData = rawData;
        JsonNode jsonNode = mapper.readTree(textRawData.getData().toString());

        //3번 작업이 필요함

        return null;
    }

    private void validateRawData(RawData rawData) {
        if (rawData.getRawDataType().getDataClass() != TARGET_RAW_DATA_CLASS) {
            throw new ClassCastException(rawData.getRawDataType().getDataClass().getCanonicalName() + " is not instance of " + TARGET_RAW_DATA_CLASS.getCanonicalName());
        }
    }

    @Override
    public RawData dump0(ConfigNode configNode) {
        return null;
    }

    @Override
    public boolean isDumpable() {
        return true;
    }
}
