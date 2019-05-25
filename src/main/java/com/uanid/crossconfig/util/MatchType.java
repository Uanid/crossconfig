package com.uanid.crossconfig.util;

import java.util.List;

public enum MatchType {
    PRIMARY, ALIAS, NONE;

    //메서드명... 정말 뭘로 지어야 할지 모르겠음
    //t1, t2 중에 더 강력하게 매칭 되는것을 반환하는 기능
    public static MatchType getUpperType(MatchType t1, MatchType t2) {
        if (t1 == PRIMARY || t2 == PRIMARY) {
            return PRIMARY;
        } else if (t1 == ALIAS || t2 == ALIAS) {
            return ALIAS;
        } else {
            return NONE;
        }
    }

    public static <T> boolean matchListOfItem(T source, List<T> aliasTarget) {
        int size = aliasTarget.size();
        for (int i = 0; i < size; i++) {
            if (aliasTarget.get(i).equals(source)) {
                return true;
            }
        }
        return false;
    }

    public static <T> MatchType matchNames(T source, T primaryTarget, List<T> aliasTarget) {
        if (primaryTarget.equals(source)) {
            return MatchType.PRIMARY;
        } else if (matchListOfItem(source, aliasTarget)) {
            return MatchType.ALIAS;
        } else {
            return MatchType.NONE;
        }
    }
}