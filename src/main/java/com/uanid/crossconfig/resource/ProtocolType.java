package com.uanid.crossconfig.resource;

import com.uanid.crossconfig.common.Type;
import com.uanid.crossconfig.util.Validate;

public class ProtocolType implements Type {

    private String name;
    private String version;

    public ProtocolType(String name) {
        this(name, "NoVersion");
    }

    public ProtocolType(String name, String version) {
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
        return "ProtocolType={" + getInfo() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof ProtocolType) return false;
        ProtocolType that = (ProtocolType) o;
        return name.equals(that.name) && version.equals(that.version);
    }
}
