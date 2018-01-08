package com.oc.associate.objectives;

/**
 * Simple strings, what values will print?
 */
public class Strings {
    public static void main(String[] args) {
        System.out.println("" +3 + 4);      // 1
        System.out.println(3 + "" +4);      // 2
        System.out.println(3 + 4 +"");      // 3
        System.out.println(3 + 4);          // 4
    }
}
