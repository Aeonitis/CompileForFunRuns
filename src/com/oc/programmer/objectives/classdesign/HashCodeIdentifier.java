package com.oc.programmer.objectives.classdesign;

import java.util.HashMap;
import java.util.Map;

/**
 * A Map is nothing but a set of buckets holding key-value pairs. Each bucket corresponds to a
 * unique hashcode. When you store a key-value pair in a Map, the following things happen:
 *
 * 1. Hashcode of the key is computed. This key is used to identify the bucket where the key-value
 * must be stored.
 *
 * 2. The key - value pair is stored in that bucket wrapped in a Map.Entry object.
 *
 * 3. If multiple keys have same hashcode value, all those key-value pairs are stored in the same
 * bucket. Before adding the element to the bucket, it is compared with the existing elements of the
 * bucket using the equals method. If an equal object already exists in the bucket, it is replaced
 * with the new one.
 */
public class HashCodeIdentifier {

  public static void main(String[] args) {
    BookStore bookStore = new BookStore();
    Book book = new Book("A111");
    System.out.println(bookStore.getNumberOfCopies(book));
  }

}

class Book {

  private String isbn;

  public Book(String isbn) {
    this.isbn = isbn;
  }

  /**
   * Since we return the same hash code value for all the objects, all the key-value pairs will be kept in the same bucket.
   * Thus, a match will be found even though it will require to call equals() on all the objects.
   */
  public int hashCode(){ return 100; }

  /**
   * It is critically important to make sure that hashCode() method return the same value for two
   * objects that are equal as per equals() method. If this rule is not followed, you will not be
   * able to retrieve the value from the map using another key object that is equal to the key
   * object stored in the map.
   */
  public boolean equals(Object o) {
    return (o instanceof Book && ((Book) o).isbn.equals(this.isbn));
  }

}

class BookStore {

  Map<Book, Integer> map = new HashMap<Book, Integer>();

  public BookStore() {
    Book b = new Book("A111");
    map.put(b, 10);
    b = new Book("B222");
    map.put(b, 5);
  }

  /**
   * A look up in a Map is a three step process:
   *
   * 1. Hashcode of the key is computed. This code is used to identify the bucket where the key
   * should be looked for. 2. For all the key-value pairs in that bucket, check whether the supplied
   * key is equal to the key in the bucket using equals() method. 3. If a match exists, return the
   * value, otherwise, return null.
   */
  Integer getNumberOfCopies(Book b) {
    return map.get(b);
  }
}