package com.oc.programmer.objectives.streams;

import java.util.stream.IntStream;

public class StreamOrderOfOperation {

  public static void main(String[] args) {


    // Iterates 10 times, skips 5 of the results before printing each
    System.out.println("Limit to Offset----------");
    IntStream.iterate(0, i -> i + 1)
        .limit(10) // LIMIT
        .skip(5)   // OFFSET
        .forEach(System.out::println);

    // Skips 5 immediately, then iterates 10 times before printing each
    System.out.println("Offset to Limit----------");
    IntStream.iterate(0, i -> i + 1)
        .skip(5)   // OFFSET
        .limit(10) // LIMIT
        .forEach(System.out::println);
  }

}
