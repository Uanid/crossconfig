package com.uanid.crossconfig.rawdata;

import com.sun.istack.internal.NotNull;

public interface RawData<T> {

    @NotNull
    T getData();

    @NotNull
    RawDataType getRawDataType();

}
