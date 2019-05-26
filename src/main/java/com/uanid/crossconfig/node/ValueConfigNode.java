package com.uanid.crossconfig.node;

public class ValueConfigNode<T> extends ConfigNode<T> {
    @Override
    public T getValue() {
        return null;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.VALUE;
    }
}
