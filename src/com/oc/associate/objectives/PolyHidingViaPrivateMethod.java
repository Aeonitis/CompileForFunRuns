package com.oc.associate.objectives;

/**
 * Private Method Hiding in Polymorphism:
 - A private method may only be hidden, not overridden.
 */
public class PolyHidingViaPrivateMethod {}

abstract class Hugger {
    private void hug() {
        System.out.println("Private Hug");
    }

    // Main method in scope of this class due to Private Method
    public static void main(String[] args) {
        Hugger hugger = new Bear();
        hugger.hug();
    }
}

class Bear extends Hugger {
    protected void hug() {
        System.out.println("Protected Hug");
    }
}
