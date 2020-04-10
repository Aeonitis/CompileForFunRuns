package com.oc.programmer.objectives.streams.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * Goal: To print "JAVA"
 */
public class OperatorsUnaryOperator {

  public static void main(String[] args) {
    List<String> letters = Arrays.asList("j", "a", "v", "a");

    /**
     * INVALID METHOD###############################################################################
     * The first statement does convert each element to upper case. However, the new upper case value does not
     * get back in the the list. It is lost. Therefore, the second statement still prints the lower case value.
     */
    letters.forEach(letter -> letter.toUpperCase());
    letters.forEach(System.out::print);

    /**
     * Method 1#####################################################################################
     */
    // str->str.toUpperCase() is a valid lambda expression that captures UnaryOperator function
    UnaryOperator<String> unaryOperator = str -> str.toUpperCase();

    // The 'replaceAll' replaces each element of this list with the result of applying the
    // operator to that element.
    letters.replaceAll(unaryOperator);

    // The forEach method performs the given action for each element of the Iterable until all elements
    // have been processed by feeding each element to the given Consumer.
    // Method reference that can be used to create a Consumer instance
    letters.forEach(System.out::print);

    /**
     * Method 2#####################################################################################
     * Lambda expression that captures the Consumer functional interface.
     */
    letters.forEach(letter -> System.out.print(letter.toUpperCase()));

    /**
     * Method 3#####################################################################################
     * Collectors.joining() returns a Collector that operators on a Stream containing CharSequences (String extends CharSequence) and joins all the elements into one big String.
     */
    System.out.print(letters.stream().collect(Collectors.joining()).toUpperCase());
  }
}
