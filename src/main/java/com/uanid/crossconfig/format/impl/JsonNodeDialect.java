package com.uanid.crossconfig.format.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.*;
import com.uanid.crossconfig.format.convert.Dialect;
import com.uanid.crossconfig.node.NodeType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonNodeDialect implements Dialect<JsonNode, ValueNode, ArrayNode, ObjectNode> {
    @Override
    public NodeType getNodeType(JsonNode jsonNode) {
        JsonNodeType type = jsonNode.getNodeType();
        if (type == JsonNodeType.ARRAY) {
            return NodeType.LIST;
        } else if (type == JsonNodeType.OBJECT) {
            return NodeType.TREE;
        } else {
            return NodeType.PRIMITIVE;
        }
    }

    public Object getValue(ValueNode jsonNode) {
        switch (jsonNode.getNodeType()) {
            case ARRAY:
            case OBJECT:
                return null;
            case BINARY:
                return ((BinaryNode) jsonNode).binaryValue();
            case BOOLEAN:
                return ((BooleanNode) jsonNode).booleanValue();
            case MISSING:
            case NULL:
                return null;
            case NUMBER:
                return ((NumericNode) jsonNode).numberValue();
            case POJO:
                return ((POJONode) jsonNode).getPojo();
            case STRING:
                return ((TextNode) jsonNode).textValue();
        }
        return null;
    }

    public List<JsonNode> getList(ArrayNode listNode) {
        List<JsonNode> list = new ArrayList<>(listNode.size());
        listNode.forEach(list::add);
        return list;
    }

    public Map<Object, JsonNode> getTree(ObjectNode objectNode) {
        Map<Object, JsonNode> map = new LinkedHashMap<>();
        objectNode.fieldNames().forEachRemaining(key -> map.put(key, objectNode.get(key)));
        return map;
    }
}
