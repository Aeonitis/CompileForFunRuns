package com.oc.associate.objectives;

/**
 * Valid and Invalid scenarios of printing null & having NullPointerException
 * The method print()/println() of PrintStream takes an Object and prints out a String that is returned by calling String.valueOf(object), which in turn calls toString() on that object.
 */
public class NullPrint {
    int i;
    public NullPrint(int i) { this.i = i;  }
    public String toString(){
        if(i == 0) return null;
        else return ""+i;
    }

    public static void main(String[ ] args){
        NullPrint nullValid0 = new NullPrint(0);
        NullPrint nullValid2 = new NullPrint(2);
        NullPrint nullInvalid = null;
        System.out.println(nullValid2);                 // ✓ Note that as toString() is defined in Object class, all objects in java have this method. So it prints 2 first.
        System.out.println(""+nullValid0);              // ✓ Object's toString() returns null, so it prints "null". There is no NullPointerException because no method is called on null.
        System.out.println(nullInvalid.toString());     // ✗ NullPointerException because a method is called on null.
    }
}