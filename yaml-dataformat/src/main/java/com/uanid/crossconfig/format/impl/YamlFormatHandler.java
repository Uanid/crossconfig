package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.datahandler.DataFormatType;
import com.uanid.crossconfig.format.FormatHandler;
import com.uanid.crossconfig.node.ConfigNode;
import com.uanid.crossconfig.rawdata.RawData;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.BaseConstructor;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

public class YamlFormatHandler extends FormatHandler {
    private static final DataFormatType DATA_FORMAT_TYPE = new DataFormatType("Yaml", "1.1");

    private Yaml yaml;

    protected YamlFormatHandler() {
        super(DATA_FORMAT_TYPE);
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setIndent(2);
        dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Representer representer = new Representer();
        BaseConstructor constructor = new Constructor();
        this.yaml = new Yaml(constructor, representer, dumperOptions);
    }


    @Override
    protected boolean isValidRawData(RawData rawData) {
        return false;
    }

    @Override
    protected ConfigNode parseProcess(RawData rawData) throws Exception {
        return null;
    }

    @Override
    protected RawData dumpProcess(ConfigNode configNode) throws Exception {
        return null;
    }
}
