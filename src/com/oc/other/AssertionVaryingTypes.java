package com.oc.other;

/**
 * TODO: Internal Invariants   You assert that a value is within a certain constraint.  assert x < 0  is
 * an example of an internal invariant. Class Invariants   You assert the validity of an object’s
 * state.
 *
 * TODO: Class invariants are typically private methods within the class that return a  boolean . The
 * upcoming  Rectangle  class demonstrates a class invariant.
 *
 * Control Flow Invariants   You assert that a line of code you assume is unreachable is never
 * reached. he upcoming  TestSeasons class demonstrates a control flow invariant.
 *
 * TODO: Preconditions You assert that certain conditions are met before a method is invoked.
 *
 * Post Conditions You assert that certain conditions are met after a method executes successfully.
 * The following example demonstrates a control flow invariant. Suppose that we have the following
 * enum  declaration. Notice how winter is missing from the list of seasons. This is intentional.
 * Our zoo is closed in the winter because it is too cold for visitors.
 */
public class AssertionVaryingTypes {

}

// Control Flow Invariants
class TestSeasons {

  // Post Condition Assert
  public enum Seasons {
    SPRING, SUMMER, FALL
  }

  public static void test(Seasons s) {
    switch (s) {
      case SPRING:
      case FALL:
        System.out.println("Shorter hours");
        break;
      case SUMMER:
        System.out.println("Longer hours");
        break;
      default:
        assert false : "Invalid season";
    }
  }
}