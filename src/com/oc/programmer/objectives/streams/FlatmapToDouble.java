package com.oc.programmer.objectives.streams;

import java.util.Arrays;
import java.util.List;

public class FlatmapToDouble {

  public static void main(String[] args) {
    List<List<Book>> books = Arrays.asList(
        Arrays.asList(new Book("Windmills of Hyrule", 7.0), new Book("Tell me you Idiot", 9.0)),
        Arrays.asList(new Book("Dancer on the highway", 5.0),
            new Book("Easy Lover", 5.0)));

    /**
     * The flatMap method expects a Function that will take an element and create a Stream out of it.
     * It then joins each of those streams (one stream for each element in the original stream) to
     * return a big combined stream of elements. bs->bs.stream() correctly captures such a Function.
     */
    double booksSum = books.stream()
        .flatMap(bs -> bs.stream())
        .mapToDouble(book -> book.getPrice())
        .sum();
    /**
     * The mapToDouble method expects a ToDoubleFunction object that will take an argument and return a double.
     * It then returns a DoubleStream containing double primitives.
     * DoubleStream has method sum that simply returns the sum of all the elements.
     */


    System.out.println(booksSum);
  }

}

class Book {

  String title;
  double price;

  public Book(String title, double price) {
    this.title = title;
    this.price = price;
  }

  public double getPrice() {
    return price;
  }
}