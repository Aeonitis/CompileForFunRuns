package com.oc.associate.objectives;

import java.io.IOException;

/**
 * Precedence with PrecedenceExceptions
 * It will print Exception message because before the division can take place generateInteger() will throw an exception.
 * Note: In cases were multiple uncaught exceptions are thrown, the Exception that is thrown the last, is the Exception that is thrown by the method to the caller.
 */
public class PrecedenceExceptions {

    public static void exceptionConfetti() throws Exception {
        int d = 0;
        try {
            try {
                int i = 1 / (d * generateInteger());
            } catch (Exception e) {
                System.out.println(e);
                checkString(null);
            }
        } catch (NullPointerException ne) {
            System.out.println(ne + " here!");
        } finally {
            throw new IOException("Finally block triggered, even though exceptions were triggered previously!");
        }

//        System.out.println("Code is not reachable if exception will be uncaught above");
    }

    public static int generateInteger() throws Exception {
        throw new Exception("Exception here!");
    }

    /**
     * In case of null parameter, the precedence below is recommended
     * if( s == null || s.length() == 0) { ... }
     */
    public static String checkString(String s) {
        if (s.length() == 0 || s == null) {
            return "EMPTY";
        } else return "NOT EMPTY";
    }

    public static void main(String[] args) throws Exception {
        exceptionConfetti();
    }
}

