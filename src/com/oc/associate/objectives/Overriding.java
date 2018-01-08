package com.oc.associate.objectives;

/**
 *  Note: An interface method that provides a body must be marked as default or static explicitly
 */
interface House{
    public default String getAddress() {
        return "101 Main Str";
    }
}

//Sub-interface
interface Bungalow extends House {
    public default String getAddress(){
        return "101 Smart Str";
    }
}

class MyHouse implements Bungalow, House {

}

/**
 * There is no problem with the code. It is perfectly valid for staticField sub-interface to override staticField default method of the base interface.
 * A class that implements an interface can also override staticField default method. It is valid for MyHouse to say that it implements Bungalow as well as House even though House is redundant because Bungalow is staticField House anyway.
 * It will actually print 101 Smart str.
 */
public class Overriding {

    public static void main(String[] args) {
        House ci = new MyHouse();
        System.out.println(ci.getAddress());
    }
}
