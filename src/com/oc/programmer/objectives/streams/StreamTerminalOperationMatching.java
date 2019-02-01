package com.oc.programmer.objectives.streams;

import java.util.Arrays;
import java.util.List;

public class StreamTerminalOperationMatching {

  static List<Integer> integerList = Arrays.asList(11, 11, 22, 33, 33, 55, 66);

  public static void main(String[] args) {

    /**
     * noneMatch returns true only if none of the elements in the stream satisfy the given Predicate.
     * Here, all the elements are divisible by 11 and x%11 will be 0 for each element.
     * Therefore, the given Predicate will return false for every element, causing noneMatch to return true.
     */
    boolean noneMatchBoolean = integerList.stream().noneMatch(x -> x % 11 > 0);
    System.out.println(noneMatchBoolean);

    /**
     * anyMatch(Predicate<? super T> predicate) returns whether any elements of this stream match the provided predicate.
     * May not evaluate the predicate on all elements if not necessary for determining the result.
     * If the stream is empty then false is returned and the predicate is not evaluated.
     * This is a short-circuiting terminal operation.
     */
    boolean anyMatchBoolean = integerList.stream().distinct().anyMatch(x -> x == 11);
    System.out.println(anyMatchBoolean);

    // Invalid - These will not compile because noneMatch/allMatch/anyMatch require a Predicate object as an argument, not an int.
//    integerList.stream().noneMatch(11);
//    integerList.stream().anyMatch(11);
//    integerList.stream().allMatch(11);

    /**
     * It will return false because for allMatch to return true, the given predicate must return true for each element of the stream.
     */
    boolean allMatchBoolean = integerList.stream().allMatch(x -> x == 11);
    System.out.println(allMatchBoolean);

  }

}
