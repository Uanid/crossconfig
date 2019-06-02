package com.uanid.crossconfig.format.convert;


import com.uanid.crossconfig.exception.ConfigException;
import com.uanid.crossconfig.node.NodeType;

public abstract class AbstractRecursiveConverter<In, Out, ValueNode, ListNode, TreeNode> implements Converter<In, Out> {

    protected Dialect<In, ValueNode, ListNode, TreeNode> dialect;

    public AbstractRecursiveConverter(Dialect<In, ValueNode, ListNode, TreeNode> dialect) {
        this.dialect = dialect;
    }

    @Override
    public final Out convert(In in) {
        NodeType nodeType = dialect.getNodeType(in);
        switch (nodeType) {
            case VALUE:
                return convertValue((ValueNode) nodeType);
            case LIST:
                return convertList((ListNode) nodeType);
            case TREE:
                return convertTree((TreeNode) nodeType);
            default:
                //애초에 노드 타입이 3개라서 발생 불가능한 경우인데...
                throw new ConfigException("Unknown NodeType");
        }
    }

    protected abstract Out convertValue(ValueNode node);

    protected abstract Out convertList(ListNode node);

    protected abstract Out convertTree(TreeNode node);
}
