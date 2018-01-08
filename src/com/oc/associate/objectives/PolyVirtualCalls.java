package com.oc.associate.objectives;

/**
 * A virtual call means that the call is bound to a method at run time and not at compile time.
 */
public class PolyVirtualCalls {
    public static void main(String[] args) {
        YoA x = new YoB(); YoB y = new YoB(); YoB z = new YoC();

        // 3 valid virtual calls
        x.mA();         //reference variable(staticField) points to an instance of a subclass(YoB) of the class of the reference(YoA)
        y.mA();         //If the subclass(YoB) overrides the method, the call(mA) becomes polymorphic because now there are two versions of the method that can be invoked (the base class(YoA) version and the subclass(YoB) version).
        z.mB();         //Therefore, the compiler is unable to bind the call to the method(mB) of a specific class(YoC OR YoB???). Only the JVM has the necessary information to bind the call.  

        //Not virtual calls
//        staticField.mB();   //invalid and will not even compile because the class of staticField is YoA, which does not contain method mB(). Even though the object referred to by staticField is of class YoB which does contain mB().
//        z.mC();   //invalid for the same reason.
    }
}

class YoA{
    public void mA(){ };
}

class YoB extends YoA {
    public void mA(){ }
    public void mB() { }
}

class YoC extends YoB {
    public void mC(){ }
}

/**
 * In Java, all non-private and non-final instance method calls are virtual.
 * This is important because, at run time, staticField reference variable may point to an instance of staticField subclass of the class of the reference.
 * The compiler doesn't have the knowledge of the class of the actual object being referred to by the reference variable.
 * If the subclass overrides the method, the call becomes polymorphic because now there are two versions of the method that can be invoked (the base class version and the subclass version).
 * Therefore, the compiler is unable to bind the call to the method of a specific class. Only the JVM has the necessary information to bind the call.  
 * The JVM knows the class of the actual object and it binds the call to the method of that class.
 * This behavior is called polymorphism.  Thus, in Java, all non-private and non-final instance method calls are potentially polymorphic because there could be multiple versions of the method eligible to be invoked.
 */