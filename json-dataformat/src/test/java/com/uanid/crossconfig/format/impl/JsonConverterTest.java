package com.uanid.crossconfig.format.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertSame;

/**
 * @author uanid
 * @since 2019-06-15
 */
public class JsonConverterTest {

    private String json1;
    private String json2;
    private String json3;
    private ObjectMapper objectMapper;
    private JsonNodeConverter converter;

    @Before
    public void before() {
        //language=JSON
        json1 = "{\"aaa\":{\"bb\":\"cc\", \"123\": \"dd\"}}";
        //language=JSON
        json2 = "\"adventure-time-formula\"";
        //language=JSON
        json3 = "[{\"aaa\":{\"bb\":\"cc\", \"123\": \"dd\"}},\"just-value\", [\"just-list\", \"just-list-2\"]]";
        objectMapper = new ObjectMapper();
        converter = new JsonNodeConverter();
    }

    @Test
    public void convertTest() throws IOException {
        ConfigNode c1 = convert(json1);
        assertSame(c1.getNodeType(), NodeType.TREE);

        ConfigNode c2 = convert(json2);
        assertSame(c2.getNodeType(), NodeType.PRIMITIVE);

        ConfigNode c3 = convert(json3);
        assertSame(c3.getNodeType(), NodeType.LIST);
    }

    private ConfigNode convert(String json) throws IOException {
        JsonNode jsonRootNode = objectMapper.readTree(json);
        return converter.convert(jsonRootNode);
    }
}