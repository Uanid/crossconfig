package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.convert.CrossConfigDialect;
import com.uanid.crossconfig.node.TreeConfigNode;
import org.ini4j.Ini;
import org.ini4j.Profile;

import java.util.Map;

public class ConfigToIniNodeConverter implements Converter<ConfigNode, Ini> {

    private CrossConfigDialect dialect;

    public ConfigToIniNodeConverter() {
        this.dialect = new CrossConfigDialect();
    }

    @Override
    public Ini convert(ConfigNode node) {
        Validate.equal(dialect.getNodeType(node), NodeType.TREE);

        Ini ini = new Ini();
        TreeConfigNode root = (TreeConfigNode) node;
        convertAndInsertToIni(ini, root);

        return ini;
    }

    private void convertAndInsertToIni(Ini ini, TreeConfigNode root) {
        Map<Object, ConfigNode> rootMap = dialect.getTree(root);

        for (Map.Entry<Object, ConfigNode> pair : rootMap.entrySet()) {
            Profile.Section section = ini.add(pair.getKey().toString());

            Validate.equal(dialect.getNodeType(pair.getValue()), NodeType.TREE);
            convertAndInsertToSection((TreeConfigNode) pair.getValue(), section);
        }
    }

    private void convertAndInsertToSection(TreeConfigNode sectionNode, Profile.Section section) {
        Map<Object, ConfigNode> sectionMap = dialect.getTree(sectionNode);
        for (Map.Entry<Object, ConfigNode> pair : sectionMap.entrySet()) {
            section.add(pair.getKey().toString(), pair.getValue().toString());
        }
    }
}
