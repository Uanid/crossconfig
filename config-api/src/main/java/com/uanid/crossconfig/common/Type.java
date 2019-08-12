package com.uanid.crossconfig.common;

public interface Type {

    String getName();

    String getInfo();

    @Override
    boolean equals(Object obj);

    @Override
    String toString();
}
