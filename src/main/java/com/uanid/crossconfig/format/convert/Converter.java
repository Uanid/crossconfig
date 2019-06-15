package com.uanid.crossconfig.format.convert;

/**
 * @author uanid
 * @since 2019-06-03
 *
 * @param <In> 변환할 대상 클래스
 * @param <Out> 변활될 결과 클래스
 */
public interface Converter<In, Out> {

    Out convert(In in);
}
