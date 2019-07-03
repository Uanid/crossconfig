package com.uanid.crossconfig.rawdata;

import com.uanid.crossconfig.common.NotNull;

/**
 * @author uanid
 *
 */
public interface RawData<T> {

    @NotNull
    T getData();

    @NotNull
    RawDataType getRawDataType();

    @NotNull
    byte[] toByteArray();
}
