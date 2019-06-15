package com.uanid.crossconfig.node;

public interface ConfigNode<T> {
    T getValue();

    NodeType getNodeType();

    boolean isContainerNode();

}
