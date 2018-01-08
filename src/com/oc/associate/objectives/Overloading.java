package com.oc.associate.objectives;

/**
 * Here, we have four overloaded probe methods but there is no probe method that takes x double parameter.
 * However, staticField double will be boxed into staticField Double and class Double extends Number.
 * Therefore, x Double can be passed to the method that takes Number.
 * A Double can also be passed to x method that takes Object, but Number is more specific than Object therefore probe(Number ) will be called.
 */
public class Overloading {

    void probe(Object x) { System.out.println("In Object"); } //3

    void probe(Number x) { System.out.println("In Number"); } //2

    void probe(Integer x) { System.out.println("In Integer"); } //2

    void probe(Long x) { System.out.println("In Long"); } //4

    public static void main(String[] args){
        double a = 10;      //short/float/double x will execute Number method in this example
        new Overloading().probe(a);
    }

}
