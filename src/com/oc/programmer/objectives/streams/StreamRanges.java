package com.oc.programmer.objectives.streams;

import java.util.stream.IntStream;

public class StreamRanges {

  public static void main(String[] args) {

    // The range method includes the starting number with the ending number i.e. 0, 1, 2, 3, 4 and 5.
    IntStream intStreamRangeClosed = IntStream.rangeClosed(0, 5);

    // The range method includes the starting number but not the ending number i.e. 0, 1, 2, 3, and 4.
    IntStream intStreamRange = IntStream.range(0, 5);

    // print both
    System.out.println("Range Closed");
    printIntStream(intStreamRangeClosed);
    System.out.println(" \n Range");
    printIntStream(intStreamRange);
  }

  public static void printIntStream(IntStream intStream) {
    intStream.forEach(i->System.out.println(i));
  }

}
