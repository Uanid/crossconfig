package com.uanid.crossconfig.format.impl;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class JsonFormatterTest {

    private String jsonList;
    private String jsonMap;
    private String jsonObejct;
    private ObjectMapper mapper;

    @Before
    public void before() {

        //language=JSON
        jsonList = "[\"aa\", \"bb\"]";
        //language=JSON
        jsonMap = "{\"aa\":{11:\"bb\"},\"cc\":\"dd\"}";
        //language=JSON
        jsonObejct = "\"aa\"";
        mapper = new ObjectMapper();
    }

    @Test
    public void testParse() throws IOException {
        assert mapper.readTree(jsonList).getClass().equals(ArrayNode.class);
        assert mapper.readTree(jsonMap).getClass().equals(ObjectNode.class);
        assert mapper.readTree(jsonObejct).getClass().equals(TextNode.class);
    }
}
