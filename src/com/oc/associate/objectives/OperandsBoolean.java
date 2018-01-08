package com.oc.associate.objectives;

/**
 | the OR operator
 & the AND operator
 ^ the XOR operator
 ! the NOT operator
 || the short-circuit OR operator
 && the short-circuit AND operator
 == the EQUAL TO operator
 != the NOT EQUAL TO operator

 & can have integral as well as boolean operands.
 */
public class OperandsBoolean {
    public static void main(String[] args) {
        boolean A = true;
        boolean B = false;

        System.out.println("A|B = "+(A|B));
        System.out.println("A&B = "+(A&B));
        System.out.println("A&&B = "+(A&&B));
        System.out.println("!A = "+(!A));
        System.out.println("A^B = "+(A^B));
        System.out.println("(A|B)&A = "+((A|B)&A));
    }
}
