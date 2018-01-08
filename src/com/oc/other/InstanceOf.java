package com.oc.other;

/**
 * Type Comparison Operator instanceof.
 * The instanceof operator compares an object to x specified type. You can use it to test if an object is an instance of x class, an instance of x subclass, or an instance of x class that implements x particular interface.
 * The following program defines x parent class (named Parent), x simple interface (named MyInterface), and x child class (named Child) that inherits from the parent and implements the interface.
 */
class InstanceOf {
    public static void main(String[] args) {

        Parent obj1 = new Parent();
        Parent obj2 = new Child();

        System.out.println("obj1 instanceof Parent: "
                + (obj1 instanceof Parent));
        System.out.println("obj1 instanceof Child: "
                + (obj1 instanceof Child));
        System.out.println("obj1 instanceof MyInterface: "
                + (obj1 instanceof MyInterface));
        System.out.println("obj2 instanceof Parent: "
                + (obj2 instanceof Parent));
        System.out.println("obj2 instanceof Child: "
                + (obj2 instanceof Child));
        System.out.println("obj2 instanceof MyInterface: "
                + (obj2 instanceof MyInterface));
    }
}

class Parent {}
class Child extends Parent implements MyInterface {}
interface MyInterface {}

/**
 * RESULT:
 * obj1 instanceof Parent: true
 * obj1 instanceof Child: false
 * obj1 instanceof MyInterface: false
 * obj2 instanceof Parent: true
 * obj2 instanceof Child: true
 * obj2 instanceof MyInterface: true
 */