package com.oc.programmer.objectives.collectionsgeneric;

import java.util.Arrays;

public class BinarySearchArray {

  static String[] stringArrayToBeSearched = {"a", "aa", "aaa", "aaaa"};

  static {
    Arrays.sort(stringArrayToBeSearched);
    System.out.println(stringArrayToBeSearched);
  }

  public static void main(String[] args) {
    String valueToFind = "";
    if (args.length != 0) {
      System.out.println("length: " + args.length);
      valueToFind = args[0];
      System.out.println("valueToFind: " + valueToFind);
    }

    /**
     * Searches the specified array for the specified object using the binary searchx algorithm.
     * The array must be sorted into ascending order according to the natural ordering of its
     * elements (as by Sort(Object[]), above) prior to making this call.
     *
     * If it is not sorted, the results are undefined.
     * (If the array contains elements that are not mutually comparable (for example,strings and integers),
     * it cannot be sorted according to the natural order of its elements, hence results are undefined.)
     *
     * If the array contains multiple elements equal to the specified object, there is no guarantee which one will be found.
     */
    System.out.println(Arrays.binarySearch(stringArrayToBeSearched, valueToFind));

    /**
     * Parameters:
     * 	a - the array to be searched.
     * 	key - the value to be searched for.
     * Returns:
     * 	index of the valueToFind key, if it is contained in the array; otherwise, (-(insertion point) - 1).
     * 	The insertion point is defined as the point at which the key would be inserted into the array:
     * 	  the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key.
     * 	Note that this guarantees that the return value will be >= 0 if and only if the key is found.
     *
     * Throws:
     * 	ClassCastException - if the valueToFind key is not comparable to the elements of the array.
     */
  }
}