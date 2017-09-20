package com.oc.associate.studyguide.assessment.chap1;

/**
 * Q:1
 * Identifiers (Letter, Underscore, Dollar Sign) are ok.
 * Class & Instance variables e.g. '$' have default values and allow referencing
 * Problem: local variable 'a_b' not initialized, needs assignment, and defaults to null. Won't compile
 */
public class _C {
    private static int $;

    public static void main(String[] main) {
        String a_b;
        System.out.print($);
        System.out.print(a_b);
    }
}