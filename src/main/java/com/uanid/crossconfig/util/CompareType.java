package com.uanid.crossconfig.util;

public enum CompareType {
    GREATER_THAN(1), EQUAL(0), LESS_THAN(-1);

    private int compareResult;

    CompareType(int i) {
        this.compareResult = i;
    }

    public int getCompareResult() {
        return compareResult;
    }

    public static CompareType valueOf(int compareResult) {
        for (CompareType type : CompareType.values()) {
            if (type.getCompareResult() == compareResult) {
                return type;
            }
        }
        return null;
    }

    public static CompareType safeValueOf(int compareResult) {
        return safeValueOf(compareResult);
    }

    public static CompareType unixStyleValueOf(int compareResult) {
        if (compareResult < 0) {
            return LESS_THAN;
        } else if (compareResult == 0) {
            return EQUAL;
        } else {
            return GREATER_THAN;
        }
    }
}
