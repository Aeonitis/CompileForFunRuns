package com.oc.associate.objectives;

/**
 * - Only String, byte, char, short, int, (and their wrapper classes Byte, Character, Short, and Integer), and enums can be used as types of a switch variable. (String is allowed only since Java 7).
 */
public class StatementsSwitch {

    final int INTEGER_CONSTANT = 4;

    public void switchSimple(){

        int i = 1;                              // The switch variable must be big enough to hold all the case constants e.g. if it is of type char, then none of the case constants can be greater than 65535 because a char's range is from 0 to 65535.
        switch (i) {                            // The case constants must be assignable to the switch variable. For example, if your switch variable is of class int, your case labels must use int as well, it's wrapper class Integer would not compile
            default:                            // At most one default label may be associated with the same switch statement.
                System.out.println("YO");
            case 1:                             // No two of the case constant expressions associated with a switch statement may have the same value.
                System.out.println("NO");
            case INTEGER_CONSTANT:              // All case labels should be COMPILE TIME CONSTANTS, including literals...
                System.out.println("HO");
        }
    }

}
