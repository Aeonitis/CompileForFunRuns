package com.oc.programmer.objectives.classdesign;

/**
 * Note: values() method is not defined in java.lang.Enum class. It is automatically added by the compiler when you define an enum
 */
public class EnumRetrieval {

  enum Card { HEART, CLUB, SPADE, DIAMOND; }

  public static void main(String[] args) {
    for(Card c : Card.values()) System.out.print(c+" ");

//    System.out.println(Card[0]);      // Invalid
    System.out.println("\nValue of card is:" + Card.valueOf("HEART"));
  }
}
