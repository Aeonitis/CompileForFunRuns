package com.oc.programmer.objectives.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamShortCircuitingTerminalOperation {

//  public static void main(String[] args) {
//    List<String> killer7List = Arrays
//        .asList("Harman Smith.", "Garcian Smith.", "Emir Parkreiner.", "Dan Smith.", "KAEDE Smith.",
//            "MASK de Smith.", "Kevin Smith.", "Coyote Smith", "Con Smith",
//            "Curtis BlackBurn", "Samantha Sitbon.", "Andrei Ulmeyda.");
//    Predicate<String> hasSmith = currentKiller -> {
//      System.out.println("Spying..." + currentKiller);
//      return currentKiller.contains("Smith");
//    };
//
//    /**
//     * Note: filter is an intermediate operation, which means it will not execute until a terminal operation is invoked on the stream.
//     * allMatch is a short circuiting terminal operation.
//     * Thus, when allMatch is invoked, the filter method will be invoked and it will keep only
//     * those elements in the stream that satisfy the condition given in the filter innerClassInstance.e. the string must be a certain length.  
//     * After this method is done, only three elements will be left in the stream.
//     * When allMatch is invoked, the code in predicate will be executed for each element until it finds a mismatch.
//     */
//    boolean flag = killer7List.stream()
//        .filter(killerName -> killerName.length() == 14)
//        .allMatch(hasSmith);
//  }

  public static void main(String[] args) {
    List<String> ls = Arrays.asList("Tom Cruise", "Tom Hart", "Tom Hanks", "Tom Brady");
    Predicate<String> p = str -> {
      System.out.println("Looking..." + str + " | length: " + str.length());
      return str.indexOf("Tom") > -1;
    };
    boolean flag = ls.stream().filter(str -> str.length() > 8).allMatch(p);
  }
}
