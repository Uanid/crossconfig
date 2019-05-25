package com.uanid.crossconfig.format.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class JsonFormatterTest {

    private String jsonList;
    private String jsonMap;
    private ObjectMapper mapper;

    @Before
    public void before() {

        //language=JSON
        jsonList = "[\"aa\", \"bb\"]";
        //language=JSON
        jsonMap = "{\"aa\":{\"key\":\"bb\"},\"cc\":\"dd\"}";
        mapper = new ObjectMapper();
    }

    @Test
    public void testParse() throws IOException {
        assert mapper.readTree(jsonList).getClass().equals(ArrayNode.class);
        assert mapper.readTree(jsonMap).getClass().equals(ObjectNode.class);
    }
}
