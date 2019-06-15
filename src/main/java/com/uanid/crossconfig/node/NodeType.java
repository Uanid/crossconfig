package com.uanid.crossconfig.node;

public enum NodeType {

    TREE,

    LIST,

    //실제 java-primitive가 아닌 config에서 사용하는 원시형 값을 의미
    //즉 java-primitive != config-primitive
    PRIMITIVE;
}
