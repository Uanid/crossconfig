package com.uanid.crossconfig.format.convert;

import com.uanid.crossconfig.node.*;
import org.junit.After;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * @author uanid
 * @since 2019-06-08
 * <p>
 * ConfigNode -> JavaPrimitive 변환 테스트
 */
public class CrossConfigConverterTest {

    private CrossConfigConverter converter;
    private ConfigNodeSampler sampler;
    private JavaPrimitiveDialect dialect;

    @Before
    public void setUp() throws Exception {
        converter = new CrossConfigConverter();
        sampler = new ConfigNodeSampler();
        dialect = new JavaPrimitiveDialect();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void convert() {
        TreeConfigNode root = sampler.getSampleTreeNode();
        Map<Object, Object> map = (Map<Object, Object>) converter.convert(root);

        //System.out.println("Node: " + root.toString());
        //System.out.println("Map: " + map.toString());

        for (PrimitiveConfigNode key : root.getKeys()) {
            //System.out.println(key.toString() + "@" + root.get(key).toString());
            //System.out.println(map.get(key.getValue()));
            NodeType t1 = root.get(key).getNodeType();
            NodeType t2 = dialect.getNodeType(map.get(key.getValue()));
            assertEquals(t1, t2);
        }
    }
}