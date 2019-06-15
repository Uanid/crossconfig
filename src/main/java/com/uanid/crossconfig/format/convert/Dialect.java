package com.uanid.crossconfig.format.convert;

import com.uanid.crossconfig.node.NodeType;

import java.util.List;
import java.util.Map;

/**
 * @param <ParentNode> 모든 노드들의 최상위 클래스
 * @param <ValueNode>  단일 원시형 값을 가진 노드
 * @param <ListNode>   배열이나 리스트 값을 가진 노드
 * @param <TreeNode>   Map또는 트리형 값을 가진 노드
 * @author uanid
 * @since 2019-06-05
 */
public interface Dialect<ParentNode, ValueNode, ListNode, TreeNode> {

    NodeType getNodeType(ParentNode node);

    Object getValue(ValueNode node);

    List<ParentNode> getList(ListNode node);

    Map<Object, ParentNode> getTree(TreeNode node);
}
