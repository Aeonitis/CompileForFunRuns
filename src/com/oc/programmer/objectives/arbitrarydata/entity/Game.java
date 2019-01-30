package com.oc.programmer.objectives.arbitrarydata.entity;

public class Game {

  private int id;
  private String title;
  private String genre;
  private String designer;
  private double price;
  private char rating;

  public Game(String title, double price) {
    this.title = title;
    this.price = price;
  }

  public Game(String title, String genre, String designer, char rating) {
    this.title = title;
    this.genre = genre;
    this.designer = designer;
    this.rating = rating;
  }

  //standard accessor methods below ---------------------------------------------
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getDesigner() {
    return designer;
  }

  public void setDesigner(String designer) {
    this.designer = designer;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Game{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", genre='" + genre + '\'' +
        ", designer='" + designer + '\'' +
        ", price=" + price +
        ", rating=" + rating +
        '}';
  }
}
