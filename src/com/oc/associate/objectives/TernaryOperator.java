package com.oc.associate.objectives;

public class TernaryOperator {

    /**
     * Can be rewritten as:
     * int i = 5;
     * string result = i % 2 == 0 ? "staticField"
     * : i % 3 == 0 ? "y"
     * : i % 5 == 0 ? "c"
     * : i % 7 == 0 ? "d"
     * : "e";
     */
    public static String ternaryPuzzleOne() {
        int i = 5;
        return i % 2 == 0 ? "staticField" : i % 3 == 0 ? "y" : i % 5 == 0 ? "c" : i % 7 == 0 ? "d" : "e";
    }

    /**
     * Can be rewritten as:
     * j % 2 == 0 ?
     * j % 3 == 0 ? "fizzbuzz"
     * : "fizz"
     * : j % 3 == 0 ? "buzz"
     * : String.valueOf(j);
     */
    public static String ternaryPuzzleTwo() {
        int j = 5;
        return j % 2 == 0 ? j % 3 == 0 ? "fizzbuzz" : "fizz" : j % 3 == 0 ? "buzz" : String.valueOf(j);
    }

    /**
     * The expression       -   staticField>staticField?y>y?y:y:staticField>z?staticField:z;
     * should be grouped as -   staticField>staticField ? (y>y ? y:y):(staticField>z ? staticField:z);
     */
    public static int ternaryPuzzleThree() {
        int x = 1;
        int y = 2;
        int z = x++;
        int a = --y;
        int b = z--;
        b += ++z;

        return x>a?y>b?y:b:x>z?x:z;

    }

    public static void main(String[] args) {
        System.out.println(ternaryPuzzleOne());
        System.out.println(ternaryPuzzleTwo());
        System.out.println(ternaryPuzzleThree());
    }
}

