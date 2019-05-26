package com.uanid.crossconfig.node;

public abstract class ConfigNode<T> {
    public abstract T getValue();

    public abstract NodeType getNodeType();
}
