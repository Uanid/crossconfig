package com.uanid.crossconfig.node;

import java.util.Objects;

public class PrimitiveConfigNode<T> implements ConfigNode<T> {

    private T value;

    public PrimitiveConfigNode(T value) {
        this.value = value;
    }

    public ValueType getValueType() {
        return null;
    }

    public void set(T value){
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.PRIMITIVE;
    }

    @Override
    public boolean isContainerNode() {
        return false;
    }

    @Override
    public String toString() {
        return "Primitive{" + value + "}";
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimitiveConfigNode<?> that = (PrimitiveConfigNode<?>) o;
        return Objects.equals(value, that.value);
    }
}
