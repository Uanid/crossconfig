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
public class DefaultFormatter implements Formatter {

    private FormatterType formatterType;
    private FormatHandler formatHandler;

    public DefaultFormatter(FormatterType formatterType, FormatHandler formatHandler) {
        this.formatterType = formatterType;
        this.formatHandler = formatHandler;
    }

    @Override
    public ConfigNode parse(RawData rawData) throws ParseFailException {
        return formatHandler.parse(rawData);
    }

    @Override
    public RawData dump(ConfigNode configNode) throws DumpFailException {
        return formatHandler.dump(configNode);
    }

    @Override
    public FormatterType getFormatterType() {
        return formatterType;
    }

    @Override
    public DataFormatType getDataFormatType() {
        return formatHandler.getDataFormatType();
    }

}
