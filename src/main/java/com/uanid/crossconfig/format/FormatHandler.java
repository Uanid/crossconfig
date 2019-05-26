package com.uanid.crossconfig.format;

import com.uanid.crossconfig.node.ConfigNode;
import com.uanid.crossconfig.rawdata.RawData;

public abstract class FormatHandler {

    private DataFormatType dataFormatType;

    public FormatHandler(DataFormatType dataFormatType) {
        this.dataFormatType = dataFormatType;
    }

    public final ConfigNode parse(RawData rawData) throws ParseFailException {
        try {
            return parse0(rawData);
        } catch (Exception e) {
            throw new ParseFailException("Dump fail because of " + e.getMessage(), e);
        }
    }


    public final RawData dump(ConfigNode configNode) throws DumpFailException {
        try {
            return dump0(configNode);
        } catch (Exception e) {
            throw new DumpFailException("Dump fail because of " + e.getMessage(), e);
        }
    }

    protected abstract ConfigNode parse0(RawData rawData) throws Exception;

    protected abstract RawData dump0(ConfigNode configNode) throws Exception;

    public DataFormatType getDataFormatType() {
        return dataFormatType;
    }

}
