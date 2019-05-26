package com.uanid.crossconfig.node;

import java.util.List;

public class ListConfigNode extends ConfigNode<List<ConfigNode>> {

    private List<ConfigNode> list;

    public ListConfigNode(List<ConfigNode> list) {
        this.list = list;
    }

    @Override
    public List<ConfigNode> getValue() {
        return null;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.LIST;
    }

    public void add(ConfigNode node) {
        list.add(node);
    }

    public ConfigNode get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public void remove(int index) {
        list.remove(index);
    }

    public void remove(ConfigNode node) {
        list.remove(node);
    }
}
