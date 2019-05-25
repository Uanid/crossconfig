package com.uanid.crossconfig.format;

import com.uanid.crossconfig.node.ConfigNode;
import com.uanid.crossconfig.rawdata.RawData;
import com.uanid.crossconfig.type.Type;
import com.uanid.crossconfig.util.StringUtils;

import java.util.List;

/**
 * @author uanid
 * @since 2019-05-19
 */
public class Formatter {

    private FormatterType formatterType;
    private FormatHandler formatHandler;

    public Formatter(FormatterType formatterType, FormatHandler formatHandler) {
        this.formatterType = formatterType;
        this.formatHandler = formatHandler;
    }

    public ConfigNode parse(RawData rawData) throws NotParsableException {
        try {
            return formatHandler.parse(rawData);
        } catch (Exception e) {
            throw new NotParsableException("Exception caught while parsing a string", e);
        }
    }

    public RawData dump(ConfigNode configNode) throws NotDumpableException {
        try {
            return formatHandler.dump(configNode);
        } catch (Exception e) {
            throw new DumpFailException("Exception caught while dumping a config object", e);
        }
    }

    public FormatterType getFormatterType() {
        return formatterType;
    }

    public DataFormatType getDataFormatType() {
        return formatHandler.getDataFormatType();
    }

}
