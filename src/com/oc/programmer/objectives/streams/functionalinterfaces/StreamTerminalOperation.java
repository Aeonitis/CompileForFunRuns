package com.oc.programmer.objectives.streams.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminalOperation {

  public static void main(String[] args) {
    List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17);
    Stream<Integer> primeStream = primes.stream();

    /**
     * Invalid Implementation
     * A stream cannot be reused once a terminal operation has been invoked on it.
     */
    Predicate<Integer> test1 = k -> k < 10;
//    long count1 = primeStream.filter(test1)
//        .count();
//    Predicate<Integer> test2 = k->k>10;
//    long count2 = primeStream.filter(test2) // IllegalStateException: stream has already been operated upon or closed
//        .count();
//    System.out.println(count1+" "+count2);

    /**
     * Valid implementation
     */
    primeStream.collect(Collectors.partitioningBy(
        test1, Collectors.counting()))
        .values()
        .forEach(System.out::print);
  }

}
