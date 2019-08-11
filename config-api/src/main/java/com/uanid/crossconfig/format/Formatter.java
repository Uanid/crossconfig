package com.uanid.crossconfig.format;

import com.uanid.crossconfig.exception.ConfigException;
import com.uanid.crossconfig.format.datahandler.DataFormatType;
import com.uanid.crossconfig.node.ConfigNode;
import com.uanid.crossconfig.rawdata.RawData;

public interface Formatter {
    ConfigNode parse(RawData rawData) throws ConfigException;

    RawData dump(ConfigNode configNode) throws ConfigException;

    FormatterType getFormatterType();

    DataFormatType getDataFormatType();
}
