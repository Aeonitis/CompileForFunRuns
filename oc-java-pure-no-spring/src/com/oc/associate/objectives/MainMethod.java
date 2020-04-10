package com.oc.associate.objectives;

/**
 * Although this class may seem like it won't compile, it compiles fine yet throws an Error, Why?
 */
public class MainMethod {
    public static int mains(String[] args) {
        System.out.println("Running...");
        return 1;
    }
}

/**
 * The JVM seeks a method named main() which takes an array of Strings as input and returns nothing innerClassInstance.e. void return type.
 * As it won't find the void method (main() method above is returning int instead) so it gives out the following message:
 * Error: Could not find or load main class MainMethod.java.
 * Main method must return a value of type void.
 * Correct solution:    public static void main(String[] args)
 */