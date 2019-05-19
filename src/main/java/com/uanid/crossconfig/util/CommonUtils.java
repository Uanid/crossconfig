package com.uanid.crossconfig.util;

import java.util.List;

public class CommonUtils {
    public static <T> boolean matchListOfItem(List<T> list, T target) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static <T> MatchType matchNames(T primary, List<T> list, T target) {
        if (primary.equals(target)) {
            return MatchType.PRIMARY;
        } else if (matchListOfItem(list, target)) {
            return MatchType.ALIAS;
        } else {
            return MatchType.NONE;
        }
    }

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
    }
}
