package com.uanid.crossconfig.format;

import com.uanid.crossconfig.type.Type;
import com.uanid.crossconfig.util.Validate;

import java.util.Objects;

/**
 * @author uanid
 * @since 2019-05-23
 */
public class DataFormatType implements Type {

    private String name;
    private String version;

    public DataFormatType(String name) {
        this(name, "NoVersion");
    }

    public DataFormatType(String name, String version) {
        Validate.notNull(name);
        Validate.notNull(version);
        this.name = name;
        this.version = version;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }


    public String getInfo() {
        return String.format("%s/%s", name, version);
    }

    @Override
    public String toString() {
        return "DataFormatType={" + getInfo() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof DataFormatType) return false;
        DataFormatType that = (DataFormatType) o;
        return name.equals(that.name) && version.equals(that.version);
    }
}
