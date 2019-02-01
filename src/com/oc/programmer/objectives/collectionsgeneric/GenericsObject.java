package com.oc.programmer.objectives.collectionsgeneric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Flesh out the thin line between Object Type & Generic
 */
public class GenericsObject {

  public static void main(String[] args) {
    String[] numbersAsStringsArray = {"1", "2", "3"};

    // Arrays.asList(T[] ) returns an object of type List<T>.
    List<?> genericList = new ArrayList<>(Arrays.asList(numbersAsStringsArray));
    System.out.println(genericList instanceof List<?>);

    List<Object> objectList = new ArrayList<>(Arrays.asList(numbersAsStringsArray));
    System.out.println(objectList instanceof List<?>);
//    System.out.println(objectList instanceof List<Object>);   // Invalid - Illegal Generic type for instanceof

    // In this case, it will be List<String>. Therefore, elements in this list cannot be added to a List of Integers.
//    List<Integer> list2 = new ArrayList<>(Arrays.asList(numbersAsStringsArray));          // Invalid - will not compile.
//    List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(numbersAsStringsArray));   // Invalid - will not compile.

    /**
     * Both additions below wouldn't compile, as would the prints shown here
     * System.out.println(genericList instanceof List<Object>);
     * System.out.println(genericList instanceof List<String>);
     */
//    genericList.add(new Object());                      // Invalid
//    genericList.add("string to add");                   // Invalid

    objectList.add(new Object());                         // Valid
    objectList.add("");                                   // Valid

    Object objectFromGenericList = genericList.get(0);    // Valid
//    String str = genericList.get(0);                    // Invalid - will not compile.

    genericList.add(null);                                // Valid - null can be added
  }
}
