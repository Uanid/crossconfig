package com.uanid.crossconfig.util;

import java.util.List;

/**
 * @author uanid
 * @since 2019-07-07
 */
public enum MatchType {
    PRIMARY(2), ALIAS(1), NONE(0);

    private int matchLevel;

    MatchType(int matchLevel) {
        this.matchLevel = matchLevel;
    }

    public boolean isStrictThan(MatchType matchType) {
        return this.matchLevel > matchType.matchLevel;
    }

    public boolean isStrictThanAndEqual(MatchType matchType) {
        return this.matchLevel >= matchType.matchLevel;
    }

    public boolean isLiberalThan(MatchType matchType) {
        return this.matchLevel < matchType.matchLevel;
    }

    public boolean isLiberalThanAndEqual(MatchType matchType) {
        return this.matchLevel <= matchType.matchLevel;
    }

    /**
     * t1, t2 중에 더 강력하게 매칭 되는것을 반환하는 기능
     * Math.max와 동일
     */
    public static MatchType getUpperType(MatchType t1, MatchType t2) {
        if (t1 == PRIMARY || t2 == PRIMARY) {
            return PRIMARY;
        } else if (t1 == ALIAS || t2 == ALIAS) {
            return ALIAS;
        } else {
            return NONE;
        }
    }

    public static <T> MatchType compareToMatchType(T source, T primaryTarget, List<T> aliasTarget) {
        if (primaryTarget.equals(source)) {
            return MatchType.PRIMARY;
        } else if (compareMatchListOfItem(source, aliasTarget)) {
            return MatchType.ALIAS;
        } else {
            return MatchType.NONE;
        }
    }

    private static <T> boolean compareMatchListOfItem(T source, List<T> targets) {
        int size = targets.size();
        for (int i = 0; i < size; i++) {
            if (targets.get(i).equals(source)) {
                return true;
            }
        }
        return false;
    }
}