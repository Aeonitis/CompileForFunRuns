package com.oc.associate.objectives;

/**
 * Static/Instance fields are always defined before everything else.
 * TODO: Add Static initialiser, constructor, etc...
 */
public class PrecedenceInitialisation {
    { System.out.println("Initialiser I - before fields & constructor"); }
    int instanceField = 1;

    { System.out.println("Initialiser II - after fields & before constructor"); isNumberZeroOrNull(instanceField);}

    public PrecedenceInitialisation() {
        System.out.println("Constructor");
    }

    { System.out.println("Initialiser III - after fields & constructor"); }

    public static void main(String[] args) throws Exception {
        new PrecedenceInitialisation();             // Initialisers and Constructor won't be called until instantiation begins...

        System.out.println("Main Function");
        staticFunction();
        double localField = staticField;
    }

    public static void staticFunction() throws Exception{
        System.out.println("Static field: " + staticField);
    }

    public boolean isNumberZeroOrNull(Number numberToCheck) {
        if(numberToCheck.equals(0) || (numberToCheck==null)) {
            System.out.println("Variable is NULL");
            return true;
        } else {
            System.out.println("Variable Initialised!");
            return false;
        }
    }

    static double staticField = 2.0;                // Even though staticField is declared after the staticFunction() method, it will be initialized before the method is actually executed.
}