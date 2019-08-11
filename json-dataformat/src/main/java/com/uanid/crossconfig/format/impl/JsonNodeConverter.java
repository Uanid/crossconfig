package com.uanid.crossconfig.format.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.uanid.crossconfig.format.convert.NodeConverter;

/**
 * @author uanid
 * @since 2019-06-15
 */
public class JsonNodeConverter extends NodeConverter<JsonNode, ValueNode, ArrayNode, ObjectNode> {

    public JsonNodeConverter() {
        super(new JsonNodeDialect());
    }


}
