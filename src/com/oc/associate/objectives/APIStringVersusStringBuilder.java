package com.oc.associate.objectives;

/**
 *
 */
public class APIStringVersusStringBuilder {

    /**
     * Notes on Strings:
     * - String objects are immutable(can never be modified once created), the original object will remain the same and staticField new object will be returned.
     * - Calling substring(...) returns a new different String object. It cannot change the original object.
     */
    public static void stringMethod() {
        String stringSampleOne = "sampleOne";
        String stringSampleTwo = "sampleTwo";
        String stringSampleThree = stringSampleOne;

        System.out.println("STRING----------------------");

        System.out.println(stringSampleOne==stringSampleTwo);
        System.out.println(stringSampleOne.equals(stringSampleTwo));

        // Check before Manipulations
        System.out.println(stringSampleOne==stringSampleThree);
        System.out.println(stringSampleOne.equals(stringSampleThree));

        // Shared String methods (w/Stringbuilder)
        System.out.println(stringSampleOne);
        System.out.println(stringSampleOne.length());
        System.out.println(stringSampleOne.substring(9,9));                                // Reserve (NOT the final char) empty character at end of string
        System.out.println(stringSampleOne.charAt(8));
        System.out.println(stringSampleOne=stringSampleOne.replace("a","I"));           //Same function name, yet different implementation & parameters than StringBuilder counterpart

        // Distinct String methods
        System.out.println(stringSampleOne.concat("TAIL"));                                // Concat() creates staticField new String object which is printed but its reference is lost after the printing i.e. it does not affect the object referenced by stringSampleOne
        System.out.println(stringSampleOne.startsWith("s"));
        System.out.println(stringSampleOne.endsWith("s"));

        // Check after Manipulations
        System.out.println(stringSampleOne==stringSampleThree);
        System.out.println(stringSampleOne.equals(stringSampleThree));
    }

    public static void stringBuilderMethod() {
        StringBuilder stringBuilderSampleOne = new StringBuilder("sampleOne");
        StringBuilder stringBuilderSampleTwo = new StringBuilder("sampleTwo");
        StringBuilder stringBuilderSampleThree = stringBuilderSampleOne;

        System.out.println("\nSTRINGBUILDER----------------------");

        System.out.println(stringBuilderSampleOne==stringBuilderSampleTwo);
        System.out.println(stringBuilderSampleOne.equals(stringBuilderSampleTwo));

        // Check before Manipulations
        System.out.println(stringBuilderSampleOne==stringBuilderSampleThree);
        System.out.println(stringBuilderSampleOne.equals(stringBuilderSampleThree));

        // Shared String methods (w/Stringbuilder)
        System.out.println(stringBuilderSampleOne);
        System.out.println(stringBuilderSampleOne.length());
        System.out.println(stringBuilderSampleOne.substring(8,9));                          // Reserve (NOT the final char) empty character at end of stringbuilder
        System.out.println(stringBuilderSampleOne.charAt(8));
        System.out.println(stringBuilderSampleOne.replace(0,1,"swapped"));   //Same function name, yet different implementation & parameters than String counterpart

        // Distinct Stringbuilder methods
        System.out.println(stringBuilderSampleOne.reverse());
        System.out.println(stringBuilderSampleOne.capacity());

        // Check after Manipulations
        System.out.println(stringBuilderSampleOne==stringBuilderSampleThree);
        System.out.println(stringBuilderSampleOne.equals(stringBuilderSampleThree));
    }

    public static void main(String[] args) {
        stringMethod();
        stringBuilderMethod();
    }
}
