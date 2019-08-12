package com.uanid.crossconfig.format;

import com.uanid.crossconfig.exception.RuntimeConfigException;
import com.uanid.crossconfig.format.datahandler.DataFormatType;
import com.uanid.crossconfig.node.ConfigNode;
import com.uanid.crossconfig.rawdata.RawData;

public interface Formatter {
    ConfigNode parse(RawData rawData) throws RuntimeConfigException;

    RawData dump(ConfigNode configNode) throws RuntimeConfigException;

    FormatterType getFormatterType();

    DataFormatType getDataFormatType();
}
