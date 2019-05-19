package com.uanid.crossconfig.format;

import java.util.List;

/**
 * @author uanid
 * @since 2019-05-19
 */
public abstract class Formatter {

    public Object parse(List<String> lines) throws NotParsableException {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line);
        }
        return this.parse(sb.toString());
    }

    public Object parse(String str) throws NotParsableException {
        try {
            return this.parse0(str);
        } catch (Exception e) {
            throw new NotParsableException("Exception caught while parsing a string", e);
        }
    }

    public void dump(Object config) throws NotDumpableException {
        if (this.isDumpable()) {
            try {
                this.dump0(config);
            } catch (Exception e) {
                throw new NotDumpableException("Exception caught while dumping a config object", e);
            }
        } else {
            throw new NotDumpableException("Not dumpable data accessor");
        }
    }

    public abstract boolean isDumpable();

    public abstract String dump0(Object config);

    public abstract Object parse0(String str);

    //이게 작명이 진짜 좋은건가?
    public String getInfo() {
        return this.getName() + "-" + this.getFormatInfo();
    }

    //이게 작명이 진짜 좋은건가? 2
    public String getFormatInfo() {
        return this.getFormatName() + "/" + this.getFormatVersion();
    }

    public abstract String getName();

    public abstract String getFormatName();

    public abstract String getFormatVersion();

}
