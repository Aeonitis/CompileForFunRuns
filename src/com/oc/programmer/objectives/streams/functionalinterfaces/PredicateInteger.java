package com.oc.programmer.objectives.streams.functionalinterfaces;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Both versions work the same with one slight difference:
 *  Predicate<Integer> requires boxing to an Integer object.
 */
public class PredicateInteger {

  public static void main(String[] args) {

    Predicate<Integer> predicateOfIntegerType = (x)-> x < 0;
    System.out.println(predicateOfIntegerType.test(123));

    IntPredicate intPredicate = (x)-> x < 0;
    System.out.println(intPredicate.test(123));
  }

}
