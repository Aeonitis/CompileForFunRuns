package com.oc.programmer.objectives.streams;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class StreamOptionals {

  public static void main(String[] args) {

    // The range method includes the starting number but not the ending number i.e. 0, 1, 2, 3, and 4.
    IntStream myIntStream = IntStream.range(0, 5);

    /**
     * The average method of all numeric streams (i.e. IntStream, LongStream, and DoubleStream) returns an
     * OptionalDouble and not a double. It never returns a null.
     *
     * In this case, the average of the given 5 numbers is 2,
     * so it returns an OptionalDouble containing 2.0.
     */
    OptionalDouble x = myIntStream.average();
    System.out.println(x);

    /**
     * The sum method which always returns a primitive value of the same type as
     *      the type of the stream (i.e. int, long, or double).
     */
    int intStreamSum = myIntStream.sum();
    System.out.println(intStreamSum);


    /**
     * OptionalDouble never returns a null.
     * If there are no elements in the stream, it returns OptionalDouble.empty but not 0.
     */
    OptionalDouble emptyOptionalDouble = OptionalDouble.empty();
    System.out.println(emptyOptionalDouble);
  }

}
