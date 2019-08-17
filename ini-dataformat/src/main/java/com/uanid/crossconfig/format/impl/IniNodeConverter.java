package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.convert.Converter;
import com.uanid.crossconfig.node.ConfigNode;
import com.uanid.crossconfig.node.PrimitiveConfigNode;
import com.uanid.crossconfig.node.TreeConfigNode;
import org.ini4j.Ini;
import org.ini4j.Profile;

public class IniNodeConverter implements Converter<Ini, ConfigNode> {

    @Override
    public ConfigNode convert(Ini ini) {
        TreeConfigNode treeConfigNode = new TreeConfigNode();
        for (String sectionName : ini.keySet()) {
            Profile.Section section = ini.get(sectionName);
            TreeConfigNode sectionNode = this.convertSectionToConfigNode(section);
            treeConfigNode.put(new PrimitiveConfigNode<>(sectionName), sectionNode);
        }

        return treeConfigNode;
    }

    private TreeConfigNode convertSectionToConfigNode(Profile.Section section) {
        TreeConfigNode sectionNode = new TreeConfigNode();
        for (String itemKey : section.childrenNames()) {
            String itemValue = section.get(itemKey);
            sectionNode.put(new PrimitiveConfigNode<>(itemKey),new PrimitiveConfigNode<>(itemValue));
        }
        return sectionNode;
    }
}
