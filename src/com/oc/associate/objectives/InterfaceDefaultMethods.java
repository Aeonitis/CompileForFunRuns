package com.oc.associate.objectives;

/**
 * Default methods enable to add new functionality to existing interfaces without breaking older implementation of these interfaces.
 * When we extend an interface that contains a default method, we are able to:
 * - Not override the default method and will inherit the default method.
 * - Override the default method similar to other methods we override in subclass..
 * - Redeclare default method as abstract, which force subclass to override it.
 *
 * This class inherits unrelated defaults for defaultMethod() from types InterfaceI and InterfaceII.
 *
 * You can have a class inherit a method with the same signature from an interface and a superclass.
 * This is allowed because the superclass's version always overrides the interface's version.
 * The class doesn't get two implementations. It gets only the version from the super class.
 */
public class InterfaceDefaultMethods implements InterfaceI, InterfaceII , InterfaceIII{
    //This class will compile because it provides its own implementation of defaultMethod.   
    public void defaultMethod() {
        System.out.println("in InterfaceDefaultMethods.defaultMethod");

        // If we want to invoke default implementation provided by any 'super interface' rather than our own implementation...
        InterfaceI.super.defaultMethod();
        InterfaceII.super.defaultMethod();
        // ...choosing any default implementation or both as part of our new method

        InterfaceIII.defaultMethod();   // Static calls can also work with Interfaces
    }

    public static void main(String[] args) {
        InterfaceDefaultMethods idm = new InterfaceDefaultMethods();
        idm.defaultMethod();

    }
}

interface InterfaceI {
    public default void defaultMethod() {
        System.out.println("in InterfaceI.defaultMethod");
    }
}

interface InterfaceII {
    public default void defaultMethod() {
        System.out.println("in InterfaceII.defaultMethod");
    }
}

interface InterfaceIII {
    public static void defaultMethod() {
        System.out.println("in InterfaceIII.staticMethod");
    }
}

//class OtherInterfaceDefaultMethods implements InterfaceI, InterfaceII {
//    //This class will not compile as it doesn't implement the methods.
//}

