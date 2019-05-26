package com.uanid.crossconfig.node;

import java.util.Map;

public class TreeConfigNode extends ConfigNode<Map<ConfigNode, ConfigNode>> {

    private Map<ValueConfigNode, ConfigNode> map;

    @Override
    public Map<ConfigNode, ConfigNode> getValue() {
        return null;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.TREE;
    }

    public ConfigNode get(ValueConfigNode key) {
        return map.get(key);
    }

    public void remove(ValueConfigNode key){
        map.remove(key);
    }

    public void put(ValueConfigNode key, ConfigNode value){
        map.put(key, value);
    }
}
