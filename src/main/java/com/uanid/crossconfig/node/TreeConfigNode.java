package com.uanid.crossconfig.node;

import java.util.*;

public class TreeConfigNode implements ConfigNode<Map<PrimitiveConfigNode, ConfigNode>> {

    private Map<PrimitiveConfigNode, ConfigNode> map;

    public TreeConfigNode() {
        this.map = new LinkedHashMap<>();
    }

    public TreeConfigNode(Map<PrimitiveConfigNode, ConfigNode> map) {
        this.map = new LinkedHashMap<>(map);
    }

    @Override
    public Map<PrimitiveConfigNode, ConfigNode> getValue() {
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

    public ConfigNode get(String key) {
        return map.get(new PrimitiveConfigNode<>(key));
    }

    // TODO: 이거 불변 set맞음?
    public Set<PrimitiveConfigNode> getKeys() {
        return map.keySet();
    }

    // TODO: 이거 불변 collection맞음?
    public Collection<ConfigNode> getValues() {
        return map.values();
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

    @Override
    public String toString() {
        return "TreeNode" + map;
    }
}
