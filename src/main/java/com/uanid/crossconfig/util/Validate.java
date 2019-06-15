package com.uanid.crossconfig.util;

import com.uanid.crossconfig.exception.NotEqualException;

import java.util.InputMismatchException;
import java.util.Objects;

public class Validate {

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
     * o1 == o2 : OK
     * o1 != o2 : NO
     */
    public static void equal(Object o1, Object o2) {
        if (o1 != o2) {
            throw new NotEqualException(o1 + " != " + o2);
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
    public static void lessThan(long n1, long n2){
        if (n1 >= n2) {
            throw new IllegalArgumentException(n1 + " must be less than " + n2);
        }
    }

    /**
     * n1 <= n2 : OK
     * n1 >  n2 : NO
     */
    public static void belowThan(long n1, long n2){
        if (n1 > n2) {
            throw new IllegalArgumentException(n1 + " must be below than" + n2);
        }
    }

    public static void positiveNumber(long n1) {
        aboveThan(n1, 0);
    }

}
