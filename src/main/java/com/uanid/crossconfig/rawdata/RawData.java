package com.uanid.crossconfig.rawdata;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public interface RawData<T> {

    @NotNull
    T getData();

    @NotNull
    RawDataType getRawDataType();

}
