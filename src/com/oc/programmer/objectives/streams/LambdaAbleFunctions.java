package com.oc.programmer.objectives.streams;

/**
 * To take advantage of lambda expressions, an interface must be a "functional" interface, which
 * basically means that the interface must have exactly one abstract method.  A lambda expression
 * essentially provides the implementation for that abstract method.
 *
 * It does not matter whether the abstract method is declared in this interface or a super
 * interface. There is no constraint on the parameter types or on the return type. The interface may
 * have other default or static methods as well but those are not relevant. All that is required is
 * that it must have exactly one abstract method.
 */
public class LambdaAbleFunctions {

  public static void main(String[] args) {
    LambdaAbleFunctions lambdaAbleFunctions = new LambdaAbleFunctions();
    lambdaAbleFunctions.useFunctionalInterface(() -> System.out.println("Display message to console!"));
    lambdaAbleFunctions.useOtherFunctionalInterface(() -> System.out.println("Display message to console!"));
  }

  public void useFunctionalInterface(AA aa) {
    aa.m2();
  }

  public void useOtherFunctionalInterface(C c) {
    c.m3();
  }

  // Invalid - No target method will be found when called
//  public void useOtherFunctionalInterface(A a) {
//    a.m1();
//  }

  // Invalid - Multiple overriding non-abstract methods will be found when called
//  public void useOtherFunctionalInterface(AAA aaa) {
//    aaa.m3();
//  }

}

// Invalid - no abstract method.
interface A {

  static void m1() {}
}

/**
 * Valid - one abstract method.
 */
interface AA extends A {

  void m2();
}

// Invalid - two abstract methods.
interface AAA extends AA {

  void m3();
}

// Invalid - no abstract method.
interface B {

  default void m1() {}
}

// Invalid - no abstract method.
interface BB extends B {

  static void m2(){}
}

/**
 * Valid - one abstract method.
 */
interface C extends BB {

  void m3();
}