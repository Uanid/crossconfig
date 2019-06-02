package com.uanid.crossconfig.node;

import java.util.LinkedHashMap;
import java.util.Map;

public class TreeConfigNode implements ConfigNode<Map<ConfigNode, ConfigNode>> {

    private Map<PrimitiveConfigNode, ConfigNode> map;

    public TreeConfigNode() {
        this.map = new LinkedHashMap<>();
    }

    @Override
    public Map<ConfigNode, ConfigNode> getValue() {
        return new LinkedHashMap<>(map);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.TREE;
    }

    @Override
    public boolean isContainerNode() {
        return true;
    }

    public ConfigNode get(PrimitiveConfigNode key) {
        return map.get(key);
    }

    public void remove(PrimitiveConfigNode key) {
        map.remove(key);
    }

    public void put(PrimitiveConfigNode key, ConfigNode value) {
        map.put(key, value);
    }

//    public Set<String>


    @Override
    public String toString() {
        return "Tree{" + map + '}';
    }
}
