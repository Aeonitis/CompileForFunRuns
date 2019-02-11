package com.oc.programmer.objectives.collectionsgeneric;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Collections.sort(List<T> ) method to sort a Collection of any class T, that class must implement
 * java.lang.Comparable interface. This interface has only one method: public int compareTo(T o),
 * where T is same as the class to which Comparable is typed. In this case, since we want to sort
 * Food instances, you can type Comparable to Food i.e. Comparable<Food> and therefore, the method
 * parameter will be Food i.e. public int compareTo(Food f).
 */
public class CompareToComparableCollectionSort {

  public static void main(String[] args) {
    ArrayList<Food> foodArrayList = new ArrayList<>();
    foodArrayList.add(new Food("Beta", 100));
    foodArrayList.add(new Food("Alpha", 80));

    System.out.println("Before sort/compareto: " + foodArrayList);
    Collections.sort(foodArrayList);
    System.out.println("After sort/compareto: " + foodArrayList);
  }
}

class Food implements Comparable<Food> {

  String name;
  int caloriesPerServing;

  public Food(String name, int calories) {
    this.name = name;
    this.caloriesPerServing = calories;
  }

  public int compareTo(Food f) {
    return this.name.compareTo(f.name);
  }

  @Override
  public String toString() {
    return "Food{" +
        "name='" + name + '\'' +
        ", caloriesPerServing=" + caloriesPerServing +
        '}';
  }
}