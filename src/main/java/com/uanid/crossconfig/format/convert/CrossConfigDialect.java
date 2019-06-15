package com.uanid.crossconfig.format.convert;

import com.uanid.crossconfig.node.*;
import com.uanid.crossconfig.util.CommonUtils;
import com.uanid.crossconfig.common.Pair;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author uanid
 * @since 2019-06-04
 */
public class CrossConfigDialect implements Dialect<ConfigNode, PrimitiveConfigNode, ListConfigNode, TreeConfigNode> {
    @Override
    public NodeType getNodeType(ConfigNode configNode) {
        return configNode.getNodeType();
    }

    @Override
    public Object getValue(PrimitiveConfigNode primitiveConfigNode) {
        return primitiveConfigNode.getValue();
    }

    @Override
    public List<ConfigNode> getList(ListConfigNode listConfigNode) {
        return listConfigNode.getValue();
    }

    @Override
    public Map<Object, ConfigNode> getTree(TreeConfigNode treeConfigNode) {
        Map<PrimitiveConfigNode, ConfigNode> preConvertedMap = treeConfigNode.getValue();
        Map<Object, ConfigNode> tree = preConvertedMap.entrySet().stream()
                .map(entry -> new Pair<>(getValue(entry.getKey()), entry.getValue()))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue, CommonUtils.getThrowingMerger(), LinkedHashMap::new));
        return tree;
    }
}
