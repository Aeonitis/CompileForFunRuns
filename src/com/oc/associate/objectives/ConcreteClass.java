package com.oc.associate.objectives;

/**
 * A concrete class is a class that has an implementation for all of its methods that were inherited from abstract or implemented via interfaces.
 * It also does not define any abstract methods of its own. This means that an instance of the class can be created/allocated with the new keyword without having to implement any methods first.
 * Therefore it can be inferred that any class that is not an abstract class or interface is a concrete class.
 */
public class ConcreteClass {
    //This is already a concrete class even if it does not implement/extend anything.
}

abstract class NotAConcreteClass {
    public static void main(String[] args) {
        ConcreteClass cc = new ConcreteClass();                     // instantiated with the new keyword (without having to implement any methods)
        final ConcreteClass concreteClass = new ConcreteClass();    // can be final
    }
}

/**
 * Notes:
 - A concrete subclass must implement all inherited abstract methods.
 - Concrete classes are, by definition, not abstract. A concrete subclass cannot be declared as abstract.
 - A superclass may have already implemented an inherited interface, hence a concrete subclass does not need to implement all methods defined in an inherited interface.
 - Concrete classes can be both final/not final.
 - Abstract methods must be overridden by a concrete subclass.
 */