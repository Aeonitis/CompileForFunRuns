package com.oc.programmer.objectives.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferencingArgs {

  private static List<String> list;

  public static void main(String[] args) {
    List<String> list = Arrays.asList("Bob Hope", "Bob Dole", "Bob Brown");
    MethodReferencingArgs methodReferencingArgs = new MethodReferencingArgs();

    methodReferencingArgs.setList(list.stream().collect(Collectors.toList()));

    /**
     * The forEach method requires a method that takes an argument.
     * The forEach method basically invokes the passed method and gives that method an element of the list as an argument.
     */
//    methodReferencingArgs.getList().forEach(MethodReferencingArgs::printNameNoArg); // Invalid
    methodReferencingArgs.getList().forEach(MethodReferencingArgs::printNameOneArg);
  }

  public static void printNameNoArg() {
    System.out.println(getList());
  }

  public static void printNameOneArg(String name) {
    System.out.println(getList());
  }

  public static List<String> getList() {
    return list;
  }

  public void setList(List<String> list) {
    this.list = list;
  }
}
