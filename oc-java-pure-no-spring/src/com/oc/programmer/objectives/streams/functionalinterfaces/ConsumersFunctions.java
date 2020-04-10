package com.oc.programmer.objectives.streams.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumersFunctions {

  public static void main(String[] args) {
    List<String> strList = Arrays.asList("a", "aa", "aaa");
    Function<String, Integer> stringIntegerFunction = x -> x.length();
    Consumer<Integer> integerConsumer = x -> System.out.print("Len:" + x + " ");
    strList.stream()
        .map(stringIntegerFunction)
        .forEach(integerConsumer);
  }

}
