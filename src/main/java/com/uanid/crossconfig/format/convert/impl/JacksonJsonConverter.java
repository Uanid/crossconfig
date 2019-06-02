package com.uanid.crossconfig.format.convert.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.uanid.crossconfig.format.convert.AbstractRecursiveConverter;
import com.uanid.crossconfig.node.*;
import com.uanid.crossconfig.util.Pair;

import java.util.List;
import java.util.Map;

public class JacksonJsonConverter extends AbstractRecursiveConverter<JsonNode, ConfigNode, ValueNode, ArrayNode, ObjectNode> {

    public JacksonJsonConverter() {
        super(new JsonNodeDialect());
    }

    @Override
    protected PrimitiveConfigNode convertValue(ValueNode jacksonNode) {
        return new PrimitiveConfigNode<>(dialect.getValue(jacksonNode));
    }

    @Override
    protected ConfigNode convertList(ArrayNode arrayNode) {
        ListConfigNode listConfigNode = new ListConfigNode();
        List<JsonNode> jsonNodeList = dialect.getList(arrayNode);

        jsonNodeList.stream()
                .map(this::convert)
                .forEach(listConfigNode::add);

        return listConfigNode;
    }

    @Override
    protected ConfigNode convertTree(ObjectNode objectNode) {
        TreeConfigNode treeConfigNode = new TreeConfigNode();
        Map<Object, JsonNode> jsonNodeMap = dialect.getTree(objectNode);

        //너무 맘에 안 드는 코드...
        jsonNodeMap.entrySet().stream()
                .map(entry -> new Pair<>(convertPrimitiveToValue(entry.getKey()), convert(entry.getValue())))
                .forEach(pair -> treeConfigNode.put(pair.getKey(), pair.getValue()));

        return treeConfigNode;
    }

    //Config에서 쓰이는 primitive type을 따로 정의해 놨음
    //ValueType Enum을 참고하도록
    private PrimitiveConfigNode convertPrimitiveToValue(Object primitiveObject) {
        return new PrimitiveConfigNode<>(primitiveObject);
    }
}
