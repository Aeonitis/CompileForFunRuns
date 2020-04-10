package com.oc.programmer.objectives.classdesign;

/**
 * Signature of the method comprises the method name, input parameters and their order. The return type is not considered.
 * So, the two methods have same signature and this is illegal.
 */
public class InheritancePolymorphism {

  public int methodA(int a) {return a * 2;}
//  public long methodA(int a) {return a;}    // You cannot have two methods of same signature in the same class.

  public static void main(String[] args) {
    int i = 0;
    i = new InheritancePolymorphism().methodA(2);
    System.out.println(i);
  }
}
