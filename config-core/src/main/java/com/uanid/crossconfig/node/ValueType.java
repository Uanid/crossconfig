package com.uanid.crossconfig.node;

public enum ValueType {
    //non-primitive type for config
    TREE, LIST, POJO,

    //primitive type for config
    INTEGER, LONG, FLOAT,
    DOUBLE, STRING, BIG_INTEGER,
    BIG_DECIMAL, BOOLEAN, NULL,
    LOCAL_DATE_TIME, ZONED_DATE_TIME;

}
