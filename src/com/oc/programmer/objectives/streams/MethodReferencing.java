package com.oc.programmer.objectives.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodReferencing {

  static List<Integer> ls;

  public static void main(String[] args) {
    ls = Arrays.asList(1, 2, 3);
    System.out.println("way one----");
    referenceWayOne();
    System.out.println("way two----");
    referenceWayTwo();
    System.out.println("way three----");
    referenceWayThree();
  }

  /**
   * Here, map method does have an implicit Integer object in the context, which is in fact the
   * current element of the list. This element will be passed as an argument to the ValueProcessor
   * constructor.
   *
   * Similarly, forEach has a ValueProcessor object in the context while invoking the process method.
   *
   * Since process is an instance method of ValueProcessor, the ValueProcessor instance that is available
   * in the context will be used to invoke the process method.
   */
  public static void referenceWayOne() {
    ls.stream()
        .map(ValueProcessor::new)
        .forEach(ValueProcessor::process);
  }

  public static void referenceWayTwo() {
    ls.stream()
        .forEach(val -> {
          new ValueProcessor(val).process();
        });
  }

  /**
   * Invalid Alternative of this method:
   * ls.stream()
   * .map(x->ValueProcessor::new(x))     // WRONG
   * .forEach(ValueProcessor::process);
   *
   * You cannot pass arguments to a constructor or method while referring to method/constructor
   * reference. If the constructor or the method requires an argument, it is passed when the
   * constructor or the method is actually invoked
   */
  public static void referenceWayThree() {
    ls.stream()
        .map(x -> {
          Function<Integer, ValueProcessor> processorFunction = ValueProcessor::new;  //referring to ValueProcessor's constructor that takes one Integer argument.    
          return processorFunction.apply(x);                                          //passing the actual Integer argument.
        })
        .forEach(ValueProcessor::process);
  }

}

class ValueProcessor {

  Integer value;

  public ValueProcessor(Integer value) {
    this.value = value;
  }

  public void process() {
    System.out.println(value + " ");
  }
}
