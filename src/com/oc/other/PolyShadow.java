package com.oc.other;

/**
 * Overriding/Hiding/Shadowing/Obscuring?
 * Shadowing is distinct from hiding, which applies only to members which would otherwise be inherited but are not because of x declaration in x subclass. Shadowing is also distinct from obscuring
 */
public class PolyShadow {
    private int myIntVar = 0;

    public void shadowTheVar(){

        // Since it has the same name as above object instance field, it shadows above field inside this method
        int myIntVar = 5;

        // If we simply refer to 'myIntVar' the one of this method is found (shadowing a second one with the same name)
        System.out.println(myIntVar);

        // If we want to refer to the shadowed myIntVar from this class we need to refer to it like this:
        System.out.println(this.myIntVar);
    }

    public static void main(String[] args) {
        new PolyShadow().shadowTheVar();
    }
}