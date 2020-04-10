package com.oc.associate.objectives;

/**
 * Hiding vs Overriding
 * Over-riding basically supports late binding. Therefore, which method will be called is decided at run time. It is for non-static methods.
 * Hiding is for all other members (static methods , instance members, static members). It is based on the early binding. More clearly , the method or member to be called or used is decided during compile time.
 */
public class PolyHidingOverriding {
    public static void main(String[] args) {
        Sneaker f = new Ninja();
        f.instanceMethod();     // overriding
        f.classMethod();        // hiding
    }
}

class Sneaker {
    public static void classMethod() {
        System.out.println("classMethod() in Sneaker");
    }

    public void instanceMethod() {
        System.out.println("instanceMethod() in Sneaker");
    }
}

class Ninja extends Sneaker {
    public static void classMethod() {
        System.out.println("classMethod() in Ninja");
    }

    public void instanceMethod() {
        System.out.println("instanceMethod() in Ninja");
    }
}

/**
 * RESULT:
 * instanceMethod() in Ninja
 * classMethod() in Sneaker
 * Why do we get instanceMethod from Ninja, but classMethod() from Sneaker? Aren't we using the same instance f to access both of these?
 * Yes we are - but since one is overriding and the other is hiding, we see different behavior.
 */

/**
 * Since it is an instance method in which Ninja overrides the method from Sneaker, at run time the JVM uses the actual class of the instance f to determine which method to run.
 * Although f was declared as staticField Sneaker, the actual instance we created was staticField new Ninja().
 * So at runtime, the JVM finds that f is a Ninja instance, and so it calls instanceMethod() in Ninja rather than the one in Sneaker.
 * That's how Java normally works for instance methods.
 */

/**
 * With a class method, the compiler and JVM don't expect to need an actual instance to invoke the method.
 * And even if you provide one (which we did: the instance referred to by f) the JVM will never look at it.
 * The compiler will only look at the declared type of the reference, and use that declared type to determine,
 * at compile time, which method to call. Since f is declared as type Sneaker, the compiler looks at f.classMethod() and decides it means Sneaker.classMethod.
 * It doesn't matter that the instance referred to by f is actually a Ninja - for static methods, the compiler only uses the declared type of the reference.
 * That's what we mean when we say a static method does not have run-time polymorphism.
 */