package com.uanid.crossconfig.format.convert;


import com.uanid.crossconfig.exception.ConfigException;
import com.uanid.crossconfig.node.*;

import java.util.Map;

/**
 * @param <ParentNode> 모든 노드들의 최상위 클래스
 * @param <ValueNode>  단일 원시형 값을 가진 노드
 * @param <ListNode>   배열이나 리스트 값을 가진 노드
 * @param <TreeNode>   Map또는 트리형 값을 가진 노드
 * @author uanid
 * @since 2019-06-05
 */
public class NodeConverter<ParentNode,
        ValueNode extends ParentNode,
        ListNode extends ParentNode,
        TreeNode extends ParentNode>
        implements Converter<ParentNode, ConfigNode> {

    private Dialect<ParentNode, ValueNode, ListNode, TreeNode> dialect;
    private ValueConverter valueConverter;
    private ListConverter listConverter;
    private TreeConverter treeConverter;

    public NodeConverter(Dialect<ParentNode, ValueNode, ListNode, TreeNode> dialect) {
        this.dialect = dialect;
        this.valueConverter = new ValueConverter();
        this.listConverter = new ListConverter();
        this.treeConverter = new TreeConverter();
    }

    //너무 약하게 제한되어 있음
    //specifiedNodeConvert가 하위 객체는 제너릭을 통해 제한되어 있지만, 상위 객체로 올라오면서 제한이 풀린 상황
    //실제 작동상 문제는 안 생김, 그러나 이해하기는 어려움
    @Override
    public final ConfigNode convert(ParentNode inNode) {
        NodeType nodeType = dialect.getNodeType(inNode);
        Converter<ParentNode, ConfigNode> specifiedNodeConverter = getTypeSpecifiedConverter(nodeType);
        return specifiedNodeConverter.convert(inNode);
    }

    private Converter getTypeSpecifiedConverter(NodeType nodeType) {
        if (nodeType == NodeType.PRIMITIVE) {
            return valueConverter;

        } else if (nodeType == NodeType.LIST) {
            return listConverter;

        } else if (nodeType == NodeType.TREE) {
            return treeConverter;

        } else {
            //애초에 노드 타입이 3개라서 발생 불가능한 경우인데... (switch-case를 사용해도 똑같은 문제가 발생)
            throw new ConfigException("Unknown NodeType");
        }
    }

    private class ValueConverter implements Converter<ValueNode, ConfigNode> {
        @Override
        public ConfigNode convert(ValueNode valueNode) {
            Object primitiveValue = dialect.getValue(valueNode);
            return new PrimitiveConfigNode<>(primitiveValue);
        }
    }

    private class ListConverter implements Converter<ListNode, ConfigNode> {
        @Override
        public ConfigNode convert(ListNode listNode) {
            ListConfigNode listConfigNode = new ListConfigNode();
            for (ParentNode preConvertedNode : dialect.getList(listNode)) {
                ConfigNode convertedNode = NodeConverter.this.convert(preConvertedNode);
                listConfigNode.add(convertedNode);
            }
            return listConfigNode;
        }
    }

    private class TreeConverter implements Converter<TreeNode, ConfigNode> {

        //tree   -> key: java primitive  , value: parent node
        //return -> key: config primitive, value: config node
        //람다로 가능하긴 한데, Linked아닌 HashMap이 튀어나옴... 그리고 mergefunction이 뭔지 정확히 몰라서 보류
        //.collect(Collectors.toMap())
        @Override
        public ConfigNode convert(TreeNode treeNode) {
            TreeConfigNode treeConfigNode = new TreeConfigNode();
            for (Map.Entry<Object, ParentNode> entry : dialect.getTree(treeNode).entrySet()) {
                PrimitiveConfigNode<Object> key = wrapConfigNode(entry.getKey());
                ConfigNode value = NodeConverter.this.convert(entry.getValue());
                treeConfigNode.put(key, value);
            }

            return treeConfigNode;
        }

        private PrimitiveConfigNode<Object> wrapConfigNode(Object javaPrimitive) {
            return new PrimitiveConfigNode<>(javaPrimitive);
        }
    }
}
