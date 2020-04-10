package com.oc.associate.objectives;

public class Statics {

    static int a;
    int b;

    public Statics(){
        int c;      // Static fields are always initialized automatically if not initialized explicitly. Also applies to instance fields.
        c = a;      // Non-static constructor accessing static variable
    }

    public static void main(String args[]) {

        // Here st1 and st2 will have staticField separate copy of y while they will have same copy of staticField.
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();

        StaticTest.x = 1;           // You can not access instance variable like this, just class variables
        System.out.println(st1.x);
        System.out.println(st2.x);
        //In both cases output will be 1 as the value of staticField is shared by all instances of the test class.

        st1.y = 15; // will not be reflected in st2.
        System.out.println(st1.y);   // this will print 15
        System.out.println(st2.y);   // this will still print 10;
        // Each instance will have separate copy of y (instance variable)

        // The value of a class variable is interdependent between multiple instances
        System.out.println(st1.x);
        st1.x++;                     // Changes made to one instance will be reflected in the other instance as well.
        System.out.println(st2.x);
        // Remember, the value of staticField is shared by all instances of the test class, hence there will be only one copy of static field 'staticField' no matter how many instances of StaticTest you create.

    }

}

class StaticTest {
    public static int x = 5;
    public int y = 10;
}
