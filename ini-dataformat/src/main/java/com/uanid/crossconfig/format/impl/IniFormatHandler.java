package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.common.WrappedByteOutputStream;
import com.uanid.crossconfig.format.datahandler.FormatHandler;
import com.uanid.crossconfig.rawdata.TextRawData;
import org.ini4j.Ini;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

public class IniFormatHandler extends FormatHandler {
    private static final DataFormatType DATA_FORMAT_TYPE = new DataFormatType("INI");

    private Converter<Ini, ConfigNode> toConfigNodeConverter;
    private Converter<ConfigNode, Ini> toIniNodeConverter;

    protected IniFormatHandler() {
        super(DATA_FORMAT_TYPE);
        this.toConfigNodeConverter = new IniNodeConverter();
        this.toIniNodeConverter = new ConfigToIniNodeConverter();
    }

    @Override
    protected boolean isValidRawData(RawData rawData) {
        return rawData.getRawDataType().equals(TextRawData.RAW_DATA_TYPE);
    }

    @Override
    protected ConfigNode parseProcess(RawData rawData) throws Exception {
        Ini ini = new Ini();

        String data = rawData.getData().toString();
        ini.load(new ByteArrayInputStream(data.getBytes()));
        return toConfigNodeConverter.convert(ini);
    }

    @Override
    protected RawData dumpProcess(ConfigNode configNode) throws Exception {
        Ini ini = toIniNodeConverter.convert(configNode);

        WrappedByteOutputStream byteOutputStream = new WrappedByteOutputStream();
        ini.getConfig().setFileEncoding(Charset.forName("UTF-8"));
        ini.store(byteOutputStream);

        return new TextRawData(new String(byteOutputStream.toByteArray(), "UTF-8"));
    }
}
