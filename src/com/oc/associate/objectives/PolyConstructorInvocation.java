package com.oc.associate.objectives;

public class PolyConstructorInvocation {}

class Avalanche {
    Avalanche() {
        print();
    }

    void print() {
        System.out.println("A");
    }
}

class Barret extends Avalanche {
    int i = 777;

    public static void main(String[] args) {
        Avalanche a = new Barret();
        a.print();
    }

    void print() {
        System.out.println(i);
    }
}

/**
 * Result:
 * 0
 * 777
 *
 * When Barret is created, first Barret's default constructor (which is not visible in the code but is automatically provided by the compiler because Barret does not define any constructor explicitly) is called.
 * The first line of this constructor is a call to super(), which invokes Avalanche's constructor. Avalanche's constructor in turn calls print().
 * Now, print is a non-private instance method and is therefore polymorphic, which means, the selection of the method to be executed depends on the class of actual object on which it is invoked.
 * Here, since the class of actual object is Barret, Barret's print is selected instead of Avalanche's print.
 * At this point of time, variable i has not been initialized (because we are still in the middle of initializing Avalanche), so its default value i.e. 0 is printed.
 */