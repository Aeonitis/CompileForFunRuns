package com.oc.programmer.objectives.assertexceptions;

public class AssertDoWhile {

  public static boolean isOverFive(int n) {
    assert n > 5;
    System.out.println("Assertion bypassed as returning true for value:" + n);
    return true;
  }

  public static void main(String[] args) {
    int i = 7;
    int j = 108;
    do {
      i--;
      if (i < 5) {
        System.out.println("Breaking..");
        break;
      }
    } while (isOverFive(j--));
    System.out.println("Broke out of loop:" + i);
  }
}
