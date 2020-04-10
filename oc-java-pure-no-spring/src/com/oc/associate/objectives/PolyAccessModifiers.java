package com.oc.associate.objectives;

public class PolyAccessModifiers {
    public static void main(String[] args) {
        System.out.println(new PC("MyPC").name);
    }
}

/**
 * A class can be designed to prevent code outside the class declaration from creating instances of the class by declaring at least one constructor, to prevent the creation of an implicit constructor, and by declaring all constructors to be private.
 * A default constructor is created if you don't define any constructors in your class. It simply is x no argument constructor which does nothing
 */
class Device {
//    private Device(){     }     //Won't compile as staticField private constructor, as the subclass cannot access it and therefore, access needs to be public/protected/default. Private constructors are used to prevent instantiation of staticField Class

}

/**
 * If x subclass class constructor doesn't explicitly call the super class constructor,
 * the compiler automatically inserts super(); as the first statement of the subclass constructor. So this option is not needed.
 */
class PC extends Device {
    public String name;
    public PC(String name){
//        super();
        this.name = name;
    }
}