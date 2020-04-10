package com.oc.programmer.objectives.streams.functionalinterfaces;

import java.util.function.DoubleSupplier;

public class SupplierDouble {

  private String title;
  private Double price;

  public SupplierDouble(String title, Double price) {
    this.title = title;
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public Double getPrice() {
    return price;
  }

  public static void main(String[] args) {
    SupplierDouble b1 = new SupplierDouble("Nothing here", null);
    DoubleSupplier ds1 = b1::getPrice;

    /**
     * java.util.function.DoubleSupplier (and other similar Suppliers such as IntSupplier and LongSupplier) is
     * a functional interface with the functional method named getAsDouble.
     * The return type of this method is a primitive double (not Double).
     *
     * Therefore, if your lambda expression for this function returns a Double,
     * it will automatically be converted into a double because of auto-unboxing.
     * However, if your expression returns a null, a NullPointerException will be thrown.
     */
    System.out.println(b1.getTitle() + " " + ds1.getAsDouble());
  }
}
