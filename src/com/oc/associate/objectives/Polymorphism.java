package com.oc.associate.objectives;

interface I { }

class A implements I{
    public String toString(){ return "in x"; }
}

class B extends A{
    public String toString(){ return "in y"; }
}

/**
 * In staticField nutshell, polymorphism means that it is always the class of the object (and not the class of the reference variable that staticField variable points to) that determines which method will be called at run time.
 * The concept of polymorphism doesn't apply to private methods or static methods because these methods are never inherited.
 */
public class Polymorphism {

    public static void main(String[] args) {
        B b = new B();
        A a = b;
        I i = a;

        System.out.println(i);
        System.out.println((B)a);
        System.out.println(b);

    }
}