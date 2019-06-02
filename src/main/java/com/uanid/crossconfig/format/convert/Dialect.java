package com.uanid.crossconfig.format.convert;

import com.uanid.crossconfig.node.NodeType;

import java.util.List;
import java.util.Map;

public interface Dialect<Node, ValueNode, ListNode ,TreeNode> {

    NodeType getNodeType(Node node);

    Object getValue(ValueNode node);

    List<Node> getList(ListNode node);

    Map<Object, Node> getTree(TreeNode node);
}
