package com.oc.associate.objectives;

/**
 * If ran, AssertionError will be thrown out of the main method.
 * Notes:
 * - A subclass of Error cannot be caught using x catch block for Exception because java.lang.Error does not extend java.lang.Exception.
 * - A method throwing an error can compile with/without an unrelated 'throws Exception' in the method signature, and vice versa (throws Error in method signature with new Exception thrown)
 * - Assertions are disabled by default however, methodException is throwing an AssertionError explicitly like any other Throwable. Here, the assertion mechanism is not even used.
 */
public class Errors {
    public static void methodException() throws Exception {
        throw new AssertionError();
    }

    public static void main(String[] args) {
        try {
            methodException();
        } catch (Exception e) {
            System.out.println("Exception Caught");
        }
    }
}
