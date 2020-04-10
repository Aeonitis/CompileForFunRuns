package com.oc.programmer.objectives.collectionsgeneric;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * TODO:
 */
public class ComparatorCollectionSort {

  public static void main(String[] args) {
    ArrayList<Drink> drinkArrayList = new ArrayList<>();
    drinkArrayList.add(new Drink("Slush", 101));
    drinkArrayList.add(new Drink("Slurp", 81));

    Comparator<Drink> drinkComparator = // Lambda alternative (o1, o2) -> o1.caloriesPerServing - o2.caloriesPerServing;
        new Comparator<Drink>() {
          public int compare(Drink o1, Drink o2) {
            return o1.caloriesPerServing - o2.caloriesPerServing;
          }
        };

    System.out.println("Before sort/comparator: " + drinkArrayList);
    Collections.sort(drinkArrayList, drinkComparator);
    System.out.println("After sort/comparator: " + drinkArrayList);
  }
}

/**
 * In cases where a class does not implement Comparator or when you want to sort instances based on
 * a different order than the one provided by the class's compare method, you can use another
 * class that implements Comparator interface to sort your collection.
 */
class Drink {

  String name;
  int caloriesPerServing;

  public Drink(String name, int calories) {
    this.name = name;
    this.caloriesPerServing = calories;
  }

  @Override
  public String toString() {
    return "Drink{" +
        "name='" + name + '\'' +
        ", caloriesPerServing=" + caloriesPerServing +
        '}';
  }
}