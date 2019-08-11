package com.uanid.crossconfig.format.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uanid.crossconfig.format.convert.Converter;
import com.uanid.crossconfig.format.convert.CrossConfigConverter;
import com.uanid.crossconfig.format.datahandler.DataFormatType;
import com.uanid.crossconfig.format.datahandler.FormatHandler;
import com.uanid.crossconfig.node.ConfigNode;
import com.uanid.crossconfig.rawdata.RawData;
import com.uanid.crossconfig.rawdata.TextRawData;

import java.io.IOException;

/**
 * @author uanid
 * @since 2019-06-15
 */
public class JsonFormatHandler extends FormatHandler<TextRawData> {
    protected static final DataFormatType DATA_FORMAT_TYPE = new DataFormatType("Json", "RFC4627|RFC8259");
    private ObjectMapper mapper;
    private Converter<JsonNode, ConfigNode> toConfigConverter;
    private Converter<ConfigNode, Object> toJavaPrimitiveConverter;

    protected JsonFormatHandler() {
        super(DATA_FORMAT_TYPE);
        this.mapper = new ObjectMapper(new JsonFactory());
        this.toConfigConverter = new JsonNodeConverter();
        this.toJavaPrimitiveConverter = new CrossConfigConverter();
    }

    @Override
    protected ConfigNode parseProcess(TextRawData textRawData) throws IOException {
        String jsonString = textRawData.getData().toString();
        JsonNode jsonNode = mapper.readTree(jsonString);
        return toConfigConverter.convert(jsonNode);
    }

    @Override
    protected boolean isValidRawData(RawData rawData) {
        return rawData.getRawDataType().equals(TextRawData.RAW_DATA_TYPE);
    }

    @Override
    protected TextRawData dumpProcess(ConfigNode configNode) throws Exception {
        Object javaNode = toJavaPrimitiveConverter.convert(configNode);
        String jsonString = mapper.writeValueAsString(javaNode);
        return new TextRawData(jsonString);
    }
}
