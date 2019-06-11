package com.uanid.crossconfig.format.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.uanid.crossconfig.format.convert.NodeConverter;

public class JsonNodeConverter extends NodeConverter<JsonNode, ValueNode, ArrayNode, ObjectNode> {

    public JsonNodeConverter() {
        super(new JsonNodeDialect());
    }


}
