package com.uanid.crossconfig.node;

import com.github.javafaker.Faker;

public class ConfigNodeSampler {

    private static double DEFAULT_NULL_NODE_RATE = 0.5D;

    private Faker faker = new Faker();
    private double nullNodeRate;

    public ConfigNodeSampler() {
        this(DEFAULT_NULL_NODE_RATE);
    }

    public ConfigNodeSampler(double nullNodeRate) {
        this.nullNodeRate = nullNodeRate;
    }

    public TreeConfigNode getSampleTreeNode() {
        return (TreeConfigNode) fillSampleNode(new TreeConfigNode());
    }

    public ConfigNode getSampleNodeWithNullRate() {
        if (faker.number().randomDouble(5, 0, 1) < nullNodeRate) {
            return null;
        }
        ConfigNode node = getSampleShallowNode();
        return fillSampleNode(node);
    }

    public <Node extends ConfigNode> ConfigNode fillSampleNode(Node configNode) {
        NodeType nodeType = configNode.getNodeType();
        if (nodeType == NodeType.TREE) {
            TreeConfigNode tree = (TreeConfigNode) configNode;
            int loop = faker.number().numberBetween(1, 5);

            for (int i = 0; i < loop; i++) {
                PrimitiveConfigNode key = getSamplePrimitiveNode();
                ConfigNode value = getSampleNodeWithNullRate();
                if (value != null) {
                    tree.put(key, value);
                }
            }
            return tree;
        } else if (nodeType == NodeType.LIST) {
            ListConfigNode list = (ListConfigNode) configNode;
            int loop = faker.number().numberBetween(0, 5);

            for (int i = 0; i < loop; i++) {
                ConfigNode node = getSampleNodeWithNullRate();
                if (node != null) {
                    list.add(node);
                }
            }
            return list;
        } else if (nodeType == NodeType.PRIMITIVE) {
            return getSamplePrimitiveNode();
        } else {
            throw new IllegalStateException("Unknown nodeType");
        }
    }

    public PrimitiveConfigNode<String> getSamplePrimitiveNode() {
        return new PrimitiveConfigNode<>(faker.zelda().character());
    }

    public ConfigNode getSampleShallowNode() {
        return getSampleShallowNode(getSampleNodeType());
    }

    public ConfigNode getSampleShallowNode(NodeType type) {
        switch (type) {
            case TREE:
                return new TreeConfigNode();
            case LIST:
                return new ListConfigNode();
            case PRIMITIVE:
                return getSamplePrimitiveNode();
            default:
                throw new IllegalStateException("Unknown nodeType");
        }
    }

    public NodeType getSampleNodeType() {
        int r = faker.number().numberBetween(0, 3);
        if (r == 0) {
            return NodeType.PRIMITIVE;
        } else if (r == 1) {
            return NodeType.LIST;
        } else {
            return NodeType.TREE;
        }
    }

}
