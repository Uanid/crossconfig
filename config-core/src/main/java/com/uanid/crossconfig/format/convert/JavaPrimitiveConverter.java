package com.uanid.crossconfig.format.convert;

import java.util.Collection;
import java.util.Map;

/**
 * @author uanid
 * @since 2019-06-05
 */
public class JavaPrimitiveConverter extends DefaultRecursiveConverter<Object, Object, Collection, Map> {

    public JavaPrimitiveConverter() {
        super(new JavaPrimitiveDialect());
    }

}
