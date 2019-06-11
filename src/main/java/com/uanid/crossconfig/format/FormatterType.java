package com.uanid.crossconfig.format;

import com.uanid.crossconfig.type.Type;
import com.uanid.crossconfig.util.CommonUtils;
import com.uanid.crossconfig.util.MatchType;
import com.uanid.crossconfig.util.StringUtils;
import com.uanid.crossconfig.util.Validate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FormatterType implements Type {

    private String name;

    //Immutable list
    private List<String> alias;

    public FormatterType(String name) {
        this(name, Collections.emptyList());
    }

    public FormatterType(String name, String... alias) {
        this(name, Arrays.asList(alias));
    }

    public FormatterType(String name, List<String> alias) {
        Validate.notNull(name);
        Validate.notNull(alias);
        this.name = name;
        this.alias = Collections.unmodifiableList(alias);
    }

    @Override
    public String getName() {
        return name;
    }

    public List<String> getAlias() {
        return alias;
    }

    public String getInfo() {
        return name + ", " + alias.toString();
    }

    @Override
    public String toString() {
        return "FormatterType={" + getInfo() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof FormatterType) return false;
        FormatterType that = (FormatterType) o;
        return name.equals(that.name) && alias.equals(that.alias);
    }

    public MatchType compareMatchType(String rawName, boolean implicitlyMatch) {
        MatchType matchType = MatchType.matchNames(rawName, getName(), getAlias());
        if (implicitlyMatch) {
            String lowerName = rawName.toLowerCase();
            String lowerThisName = getName().toLowerCase();
            List<String> lowerThisAlias = StringUtils.convertLowerCaseList(getAlias());
            MatchType implicitMatchType = MatchType.matchNames(lowerName, lowerThisName, lowerThisAlias);
            matchType = MatchType.getUpperType(matchType, implicitMatchType);
        }
        return matchType;
    }
}
