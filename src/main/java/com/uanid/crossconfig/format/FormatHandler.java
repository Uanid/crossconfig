package com.uanid.crossconfig.format;

import com.uanid.crossconfig.node.ConfigNode;
import com.uanid.crossconfig.rawdata.RawData;

public abstract class FormatHandler {

    private DataFormatType dataFormatType;

    public FormatHandler(DataFormatType dataFormatType) {
        this.dataFormatType = dataFormatType;
    }

    public abstract ConfigNode parse(RawData rawData) throws Exception;

    public RawData dump(ConfigNode configNode) throws Exception{
        if (this.isDumpable()) {
            return this.dump0(configNode);
        } else {
            throw new NotDumpableException("Not dumpable data format");
        }
    }

    public abstract RawData dump0(ConfigNode configNode);

    public abstract boolean isDumpable();

    public DataFormatType getDataFormatType() {
        return dataFormatType;
    }

}
