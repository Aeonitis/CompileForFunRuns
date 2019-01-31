package com.oc.associate.objectives;

/**
 * Abstract classes versus interfaces in Java 8 (TODO:WIP)
 * After introducing Default Method, it seems that interfaces and abstract classes are same. However, they are still different concept in Java 8.
 * Abstract classes can define constructor. They are more structured and can have a state associated with them.
 * While in contrast, default method can be implemented only in the terms of invoking other interface methods, with no reference to a particular implementation's state.
 * Hence, both use for different purposes and choosing between two really depends on the scenario context.
 */
public class AbstractVersusInterface {
}

interface BaseInterface {
    int d = 0;
    default int defaultBaseMethod() {
        return 0;
    }

    static void setNothing() {}
}

interface ExtendingInterface extends BaseInterface {
    String getExtensionName();
}

// Option 1
class SubclassValidViaImplementation implements ExtendingInterface {

    public String getExtensionName() {
        return null;
    }
}

// Option 2
abstract class SubclassValidViaAbstraction implements ExtendingInterface {}

/**
 * SIMILARITIES:
 - Both can contain public static final variables.
 - Both can be extended using the extend keyword.
 - Both can contain static methods.
 - Neither can be instantiated directly. They require a concrete subclass to be instantiated.
 *
 * DIFFERENCES:
 - All members of an interface (innerClassInstance.e. fields/variables as well as methods) are always public. Interface variables are assumed to be public static final.
 - Only interfaces can be implemented using the implement keyword.
 - All methods within them cannot be assumed to be abstract. An abstract class may contain concrete methods.
    Since Java 8, interfaces may also contain concrete methods in form of static or default methods.
 - Only interfaces can contain default methods.
 - Abstract classes inherit java.lang.Object. Even though an instance of an object that implements an interface inherits java.lang.Object,
    the interface itself doesn’t; otherwise, Java would support multiple inheritance for objects, which it does not.
 */