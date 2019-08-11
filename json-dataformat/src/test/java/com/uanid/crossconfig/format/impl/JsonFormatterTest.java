package com.uanid.crossconfig.format.impl;


import com.uanid.crossconfig.rawdata.TextRawData;
import org.junit.Before;
import org.junit.Test;

import static com.uanid.crossconfig.util.StringUtils.*;
import static com.uanid.crossconfig.util.Validate.*;

import java.io.IOException;

/**
 * @author uanid
 * @since 2019-06-15
 */
public class JsonFormatterTest {

    private RawData mapRawData;
    private RawData listRawData;
    private RawData objectRawData;

    //language=JSON
    private String mapJson;
    //language=JSON
    private String listJson;
    //language=JSON
    private String objectJson;

    private Formatter formatter;

    @Before
    public void before() {
        formatter = JsonFormatterProvider.getInstance().getFormatter();

        mapJson = "{\"aa\":{\"11\":\"bb\"},\"cc\":\"dd\"}";
        listJson = "[\"aa\", \"bb\"]";
        objectJson = "\"aa\"";

        mapRawData = new TextRawData(mapJson);
        listRawData = new TextRawData(listJson);
        objectRawData = new TextRawData(objectJson);
    }

    @Test
    public void testParse() throws IOException {
        ConfigNode treeNode = formatter.parse(mapRawData);
        equal(treeNode.getNodeType(), NodeType.TREE);
        String parsedAndDumpedMapJson = formatter.dump(treeNode).getData().toString();
        equal(withoutBlanks(parsedAndDumpedMapJson), withoutBlanks(mapJson));

        ConfigNode listNode = formatter.parse(listRawData);
        equal(listNode.getNodeType(), NodeType.LIST);
        String parsedAndDumpedListJson = formatter.dump(listNode).getData().toString();
        equal(withoutBlanks(parsedAndDumpedListJson), withoutBlanks(listJson));

        ConfigNode valueNode = formatter.parse(objectRawData);
        equal(valueNode.getNodeType(), NodeType.PRIMITIVE);
        String parsedAndDumpedObjectJson = formatter.dump(valueNode).getData().toString();
        equal(withoutBlanks(parsedAndDumpedObjectJson), withoutBlanks(objectJson));

    }
}
