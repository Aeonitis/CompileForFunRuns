package com.oc.associate.objectives;

public class LossOfPrecision {
    public static void main(String[] args) {
        int integerValue = 123456789;
        float doubleValue = integerValue;                   // The results will be different if you just change this line from a double to a float & vice versa
        checkPrecision(doubleValue, integerValue);
    }

    public static void checkPrecision(double doubleValue, int integerValue) {
        if((integerValue - (double)doubleValue)==0) {
            System.out.println("PRECISE!");
        } else {
            System.out.println("Difference found...");
        }

        System.out.println("Integer:    " + integerValue);
        System.out.println("Double:     " + doubleValue);
    }
}
