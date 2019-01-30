package com.oc.programmer.objectives;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class CollectorsFunctions {


  public static void main(String[] args) {
    //What will the following code print?
    List<Item> items = Arrays.asList(
        new Item("Pen", "Stationery", 3.0),
        new Item("Pencil", "Stationery", 2.0),
        new Item("Eraser", "Stationery", 1.0),
        new Item("Milk", "Food", 2.0),
        new Item("Eggs", "Food", 3.0));

    ToDoubleFunction<Item> doubleFunction = Item::getPrice;
    items.stream()
        .collect(Collectors
            .groupingBy(Item::getCategory)) // returns a Map where the keys are the Category values and the values are Lists of the elements.
        .forEach((a, b) -> {
          double av = b.stream().collect(Collectors
                  .averagingDouble(doubleFunction));
          // returns the average of the values returned by the doubleFunction function applied to each element of the Stream.
          // In this case, a stream is created from the List of elements belonging to each category by the call to forEach.

          System.out.println(a + " : " + av);
        });
  }
}

class Item {

  private String name;
  private String category;
  private double price;

  public Item(String name, String category, double price) {
    this.name = name;
    this.category = category;
    this.price = price;
  }

  public String getCategory() {
    return category;
  }

  public double getPrice() {
    return price;
  }
}