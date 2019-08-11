package com.uanid.crossconfig.node;

import java.util.ArrayList;
import java.util.List;

public class ListConfigNode implements ConfigNode<List<ConfigNode>> {

    private List<ConfigNode> list;

    public ListConfigNode() {
        this.list = new ArrayList<>();
    }

    public ListConfigNode(List<ConfigNode> list) {
        this.list = new ArrayList<>(list);
    }

    @Override
    public List<ConfigNode> getValue() {
        return new ArrayList<>(list);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.LIST;
    }

    @Override
    public boolean isContainerNode() {
        return true;
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

    @Override
    public String toString() {
        return "ListNode{" + list + "}";
    }
}
