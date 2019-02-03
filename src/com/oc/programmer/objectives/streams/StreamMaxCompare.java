package com.oc.programmer.objectives.streams;

import java.util.Arrays;
import java.util.List;

public class StreamMaxCompare {

  public static void main(String[] args) {
    List<Integer> ls = Arrays.asList(3, 4, 6, 9, 2, 5, 7);

    /**
     * The reduce method needs a BinaryOperator. This interface is meant to consume two arguments and produce one output.
     * It is applied repeatedly on the elements in the stream until only one element is left.
     * The first argument is used to provide an initial value to start the process.
     * (If you don't pass this argument, a different reduce method will be invoked and that returns an Optional object.)
     */
    System.out.println(ls.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b));

    /**
     * The Stream.max method requires a Comparator.
     * All you need to implement this interface using a lambda expression is a reference to any method that
     * takes two arguments and returns an int. The name of the method doesn't matter.
     *
     * That is why it is possible to pass the reference of Integer's max method as an argument to Stream's max method.
     * However, Integer.max works very differently from Integer.compare. The max method returns the maximum of
     * two numbers while the compare method returns a difference between two numbers.
     */
    System.out.println(ls.stream().max(Integer::compare).get());

//    System.out.println(ls.stream().max(Integer::max).get());      // Invalid - when you pass Integer::max to Stream's max, you will not get the correct maximum element from the stream.
//    System.out.println(ls.stream().max((a, b) -> a > b ? a : b)); // Invalid - when you pass Integer::max to Stream's max, you will not get the correct maximum element from the stream.
  }

}
