package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.DataFormatType;
import com.uanid.crossconfig.format.FormatHandler;
import com.uanid.crossconfig.format.Formatter;
import com.uanid.crossconfig.format.FormatterType;
import com.uanid.crossconfig.node.ConfigNode;
import com.uanid.crossconfig.rawdata.RawData;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.BaseConstructor;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

import java.util.Arrays;
import java.util.List;

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
