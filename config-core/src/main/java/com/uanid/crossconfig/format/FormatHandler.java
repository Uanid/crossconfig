package com.uanid.crossconfig.format;

import com.uanid.crossconfig.exception.RuntimeConfigException;
import com.uanid.crossconfig.format.datahandler.DataFormatType;
import com.uanid.crossconfig.node.ConfigNode;
import com.uanid.crossconfig.rawdata.RawData;

public abstract class FormatHandler<Raw extends RawData> {

    private DataFormatType dataFormatType;

    public FormatHandler(DataFormatType dataFormatType) {
        this.dataFormatType = dataFormatType;
    }

    public final ConfigNode parse(RawData rawData) throws RuntimeConfigException {
        try {
            if (!isValidRawData(rawData)) {
                throw new RuntimeConfigException("Raw " + rawData.getRawDataType().getDataClass().getCanonicalName() + " is not valid rawData");
            }
            return parseProcess((Raw) rawData);
        } catch (Exception e) {
            throw new RuntimeConfigException("Exception caught while parsing a rawData", e);
        }
    }

    public final Raw dump(ConfigNode configNode) throws RuntimeConfigException {
        try {
            return dumpProcess(configNode);
        } catch (Exception e) {
            throw new RuntimeConfigException("Exception caught while dumping a rawData", e);
        }
    }

    protected abstract boolean isValidRawData(RawData rawData);

    protected abstract ConfigNode parseProcess(Raw rawData) throws Exception;

    protected abstract Raw dumpProcess(ConfigNode configNode) throws Exception;

    public DataFormatType getDataFormatType() {
        return dataFormatType;
    }

}
