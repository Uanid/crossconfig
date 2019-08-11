package com.uanid.crossconfig.format.convert;

import com.uanid.crossconfig.node.TreeConfigNode;
import com.uanid.crossconfig.common.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author uanid
 * @since 2019-06-05
 */
public class JavaPrimitiveConverterTest {

    private Map<String, Object> root;
    private JavaPrimitiveConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new JavaPrimitiveConverter();

        root = new LinkedHashMap<>();
        root.put("list", Arrays.asList(1, 2, 3, 4, 5));
        root.put("valueA", "vvvvv");
        root.put("valueB", 1512);
        root.put("subtree", IntStream.range(5, 10).mapToObj(i -> new Pair<>(i + "", i)).collect(Collectors.toMap(Pair::getKey, Pair::getValue)));
    }

    @Test
    public void convert() {
        ConfigNode configNode = converter.convert(root);

        Validate.equal(configNode.getNodeType(), NodeType.TREE);

        TreeConfigNode root = (TreeConfigNode) configNode;
        Validate.equal(root.get("list").getNodeType(), NodeType.LIST);
        Validate.equal(root.get("valueA").getNodeType(), NodeType.PRIMITIVE);
        Validate.equal(root.get("valueB").getNodeType(), NodeType.PRIMITIVE);
        Validate.equal(root.get("subtree").getNodeType(), NodeType.TREE);
    }
}