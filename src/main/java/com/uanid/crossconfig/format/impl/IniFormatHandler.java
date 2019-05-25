package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.DataFormatType;
import com.uanid.crossconfig.format.FormatHandler;
import com.uanid.crossconfig.node.ConfigNode;
import com.uanid.crossconfig.rawdata.RawData;
import org.ini4j.Config;
import org.ini4j.Ini;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.BaseConstructor;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

import java.nio.charset.Charset;

public class IniFormatHandler extends FormatHandler {
    private static final DataFormatType DATA_FORMAT_TYPE = new DataFormatType("INI");

    private Ini ini;

    protected IniFormatHandler() {
        super(DATA_FORMAT_TYPE);
        this.ini = new Ini();

        //TODO: charset을 option등을 통해 주입받게...
        Config iniConfig = new Config();
        iniConfig.setFileEncoding(Charset.forName("UTF-8"));
        ini.setConfig(iniConfig);
    }

    @Override
    public ConfigNode parse(RawData rawData) throws Exception {
        return null;
    }

    @Override
    public RawData dump0(ConfigNode configNode) {
        return null;
    }

    @Override
    public boolean isDumpable() {
        return true;
    }

}
