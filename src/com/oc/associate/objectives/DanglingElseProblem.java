package com.oc.associate.objectives;

public class DanglingElseProblem {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ghi";

        if (str1.equals("def"))
            if (str2.equals("ghi"))
                System.out.println("Alphabets!");
        else System.out.println("Not sure... " + str1);
    }
}
