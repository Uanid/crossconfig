package com.uanid.crossconfig.format.convert;

import com.uanid.crossconfig.common.Pair;
import com.uanid.crossconfig.exception.RuntimeConfigException;
import com.uanid.crossconfig.node.*;
import com.uanid.crossconfig.util.CommonUtils;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * @author uanid
 * @since 2019-06-04
 */
public class CrossConfigConverter implements Converter<ConfigNode, Object> {

    private Dialect<ConfigNode, PrimitiveConfigNode, ListConfigNode, TreeConfigNode> dialect;

    public CrossConfigConverter() {
        dialect = new CrossConfigDialect();
    }

    @Override
    public Object convert(ConfigNode configNode) {
        NodeType nodeType = configNode.getNodeType();
        if (nodeType == NodeType.PRIMITIVE) {
            return convertValue((PrimitiveConfigNode) configNode);

        } else if (nodeType == NodeType.LIST) {
            return convertList((ListConfigNode) configNode);

        } else if (nodeType == NodeType.TREE) {
            return convertTree((TreeConfigNode) configNode);

        } else {
            throw new RuntimeConfigException("Unknown NodeType");

        }
    }

    private Object convertValue(PrimitiveConfigNode configNode) {
        return dialect.getValue(configNode);
    }

    private Object convertList(ListConfigNode configNode) {
        return dialect.getList(configNode).stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private Object convertTree(TreeConfigNode configNode) {
        return dialect.getTree(configNode).entrySet().stream()
                .map(entry -> new Pair<>(entry.getKey(), this.convert(entry.getValue())))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue, CommonUtils.getThrowingMerger(), LinkedHashMap::new));
    }
}
