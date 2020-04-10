package com.oc.programmer.objectives.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Print 'ArrangedInLetterOrder' as the sorted result
 */
public class StreamSorting {

  public static void main(String[] args) {
    List<Item> l = Arrays.asList(new Item(1, "Letter"), new Item(2, "Order"), new Item(3, "In"),
        new Item(3, "Arranged"));

    /**
     * Method 1
     * The call to sorted() sorts the stream of String by their natural order
     */
    l.stream()
        .map((i) -> i.getName())  // converts the stream of Items to a stream of Strings
        .sorted()
        .forEach(System.out::print);

    /**
     * Method 2
     * 1. This option uses Comparator's comparing method that accepts a function that extracts a Comparable sort key, and returns a Comparator that compares by that sort key. Note that this is helpful only if the type of the object returned by the function implements Comparable. Here, it returns a String, which does implement Comparable and so it is ok.  2. Although the map part is not required because Item class overrides the toString method to print the name anyway, it is valid.
     */
    l.stream()
        .sorted(Comparator.comparing(a -> a.getName()))
        .map((i) -> i.getName())
        .forEach(System.out::print);

    // Method 3 - Creates a Comparator using a lambda expression that compares two Item objects for their id attribute
    l.stream()
        .sorted((a, b) -> a.getName().compareTo(b.getName()))
        .map((i) -> i.getName())
        .forEach(System.out::print);
  }
}

class Item {

  private int id;
  private String name;

  public Item(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return name;
  }
}

