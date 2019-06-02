package com.uanid.crossconfig.format;

import com.uanid.crossconfig.node.ConfigNode;
import com.uanid.crossconfig.rawdata.RawData;

public interface Formatter {
    ConfigNode parse(RawData rawData) throws ParseFailException;

    RawData dump(ConfigNode configNode) throws DumpFailException;

    FormatterType getFormatterType();

    DataFormatType getDataFormatType();
}
