package com.uanid.crossconfig.util;

import com.uanid.crossconfig.exception.NotEqualException;

public class Validate {

    /**
     * bool == true : OK
     * bool == false: NO
     */
    public static void trueIs(boolean bool) {
        if (!bool) {
            throw new IllegalArgumentException(bool + " must be true");
        }
    }


    /**
     * bool == false: OK
     * bool == true : NO
     */
    public static void falseIs(boolean bool) {
        if (bool) {
            throw new IllegalArgumentException(bool + " must be false");
        }
    }

    /**
     * o1 != null : OK
     * o1 == null : NO
     */
    public static void notNull(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
    }

    /**
     * o1.equals(o2) == true : OK
     * o1.equals(o2) == false: NO
     */
    public static void equal(Object o1, Object o2) {
        if (!o1.equals(o2)) {
            throw new NotEqualException(o1 + " must be equals(method) " + o2);
        }
    }

    /**
     * n1 == n2 : OK
     * n1 != n2 : NO
     */
    public static void referenceEqual(Object o1, Object o2) {
        if (o1 != o2) {
            throw new NotEqualException(o1 + " must be reference(memory)-equals(==) " + o2);
        }
    }

    /**
     * n1 == n2 : OK
     * n1 != n2 : NO
     */
    public static void memoryEqual(Object o1, Object o2) {
        if (o1 != o2) {
            throw new NotEqualException(o1 + " must be memory(reference)-equals(==) " + o2);
        }
    }

    /**
     * n1 >  n2 : OK
     * n1 <= n2 : NO
     */
    public static void greaterThan(long n1, long n2) {
        if (n1 <= n2) {
            throw new IllegalArgumentException(n1 + " must be greater than " + n2);
        }
    }

    /**
     * n1 >= n2 : OK
     * n1 <  n2 : NO
     */
    public static void aboveThan(long n1, long n2) {
        if (n1 < n2) {
            throw new IllegalArgumentException(n1 + " must be above than " + n2);
        }
    }

    /**
     * n1 <  n2 : OK
     * n1 >= n2 : NO
     */
    public static void lessThan(long n1, long n2) {
        if (n1 >= n2) {
            throw new IllegalArgumentException(n1 + " must be less than " + n2);
        }
    }

    /**
     * n1 <= n2 : OK
     * n1 >  n2 : NO
     */
    public static void belowThan(long n1, long n2) {
        if (n1 > n2) {
            throw new IllegalArgumentException(n1 + " must be below than" + n2);
        }
    }

    /**
     * n1 >= 0 : OK
     * n1 <  0 : NO
     */
    public static void positiveNumber(long n1) {
        aboveThan(n1, 0);
    }

    /**
     * gteA <= n <= lteB : OK
     * else              : NO
     * @param gteA Greater than and equal A
     * @param n
     * @param lteB less than and equal B
     */
    public static void betweenAnB(long gteA, long n, long lteB) {
        if (!(gteA <= n && n <= lteB)) {
            throw new IllegalArgumentException(n + " must be between number " + gteA + " and " + lteB);
        }
    }

}
