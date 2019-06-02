package com.uanid.crossconfig.node;

public class PrimitiveConfigNode<T> implements ConfigNode<T> {

    private T value;

    public PrimitiveConfigNode(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.VALUE;
    }

    @Override
    public boolean isContainerNode() {
        return false;
    }

    @Override
    public String toString() {
        return "Value{" + value + '}';
    }
}
