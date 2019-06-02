package com.uanid.crossconfig.format.convert;

public interface Converter<In, Out> {

    Out convert(In in);
}
