package com.oc.associate.studyguide.assessment.chap1;

/**
 * Q:10
 * Code compiles fine.
 * Problem: Garbage Collection comments below
 */

public class Grasshopper {
    public Grasshopper(String n) {
        name = n;
    }

    public static void main(String[] args) {
        Grasshopper one = new Grasshopper("g1");
        Grasshopper two = new Grasshopper("g2");
        one = two;  // Immediately after this line, only one grasshopper object i.e. 'g1' is eligible for garbage collection, since both one and two are pointing to 'g2' object
        two = null; // Immediately after this line, only one grasshopper object i.e. 'g1' is still eligible for garbage collection. Reference one points to g1 and reference two is null
        one = null; // Immediately after this line, both Grasshopper objects are eligible for garbage collection since both one and two point to null
    }

    private String name; // Although it is traditional to declare instance variables early in the class, you don’t have to
}
