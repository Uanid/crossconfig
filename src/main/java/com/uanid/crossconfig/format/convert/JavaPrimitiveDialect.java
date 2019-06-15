package com.uanid.crossconfig.format.convert;

import com.uanid.crossconfig.node.NodeType;

import java.util.*;

/**
 * @author uanid
 * @since 2019-06-05
 */
public class JavaPrimitiveDialect implements Dialect<Object, Object, Collection, Map> {
    @Override
    public NodeType getNodeType(Object parentNode) {
        if (parentNode instanceof Map) {
            return NodeType.TREE;
        } else if (parentNode instanceof Collection) {
            return NodeType.LIST;
        } else {
            return NodeType.PRIMITIVE;
        }
    }

    @Override
    public Object getValue(Object valueNode) {
        return valueNode;
    }

    @Override
    public List<Object> getList(Collection listNode) {
        return new ArrayList<>(listNode);
    }

    public List<Object> getListByArray(Object arrayNode) {
        //TODO: 이거 validate로 바꿔야 하지 않나?
        if (!arrayNode.getClass().isArray()) {
            throw new IllegalArgumentException();
        }

        return Arrays.asList(arrayNode);
    }

    @Override
    public Map<Object, Object> getTree(Map treeNode) {
        return treeNode;
    }
}
