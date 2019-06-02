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
    protected static final DataFormatType DATA_FORMAT_TYPE = new DataFormatType("Json", "RFC4627|RFC8259");
    private static final Class TARGET_RAW_DATA_CLASS = CharSequence.class;
    private ObjectMapper mapper;

    protected JsonFormatHandler() {
        super(DATA_FORMAT_TYPE);
        this.mapper = new ObjectMapper(new JsonFactory());
    }

    @Override
    protected ConfigNode parseProcess(RawData rawData) throws IOException {
        RawData<CharSequence> textRawData = rawData;
        JsonNode jsonNode = mapper.readTree(textRawData.getData().toString());
        return null;
    }

    @Override
    protected boolean isValidRawData(RawData rawData) {
        return rawData.getRawDataType().getDataClass() != TARGET_RAW_DATA_CLASS;
    }

    @Override
    protected RawData dumpProcess(ConfigNode configNode) {
        return null;
    }
}
