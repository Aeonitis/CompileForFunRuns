package com.oc.programmer.objectives.assertexceptions;

public class AssertAlternatives {

  public static void main(String[] args) {

    try {
      System.out.println("Running first assertion...");
      methodAssertionOne();
    } catch (AssertionError error) {
      System.out.println("Caught AssertionError: " + error.getMessage());
    }

    try {
      System.out.println("Running second assertion...");
      methodAssertionTwo();
    } catch (Error error) {
      System.out.println("Caught AssertionError: " + error.getMessage());
    }

    System.out.println("Running third assertion...");
    methodAssertionThree();

    // Will not run if previous Assertion is uncaught...
    System.out.println("Running fourth assertion...");
    methodAssertionFour();
  }

  public static void methodAssertionOne() {
    int code = getCode(); // returns 0 or 1

    if (code == 0) {
      // deal with 0 ...
    } else if (code == 1) {
      // deal with 1 ...
    } else {
      assert false : "Can't process because code is out of range: " + code;
    }
  }

  public static void methodAssertionTwo() {
    int code = getCode(); // always returns 0

    if (code == 0) { // deal with 0 ...
    } else {
      assert code == 0 : "Can't process because code is out of range: " + code;
    }
  }

  public static void methodAssertionThree() {
    int code = getCode(); // returns 0 or 1      
    switch (code) {
      case 0: // deal with 0 ...             
        break;
      case 1: // deal with 1 ...             
        break;
      default:
        assert false : "Can't process because code is out of range: " + code;
    }
  }

  // Non-informative style of assert, hence no message
  public static void methodAssertionFour() {
    assert false;
  }

  public static int getCode() {
    return 2;
  }

}
