package com.oc.programmer.objectives.streams.functionalinterfaces;

import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Alternate methods to print the same result with stream conversions via Intermediate operation
 */
public class StreamIntermediateOperationFiltering {

  public static void main(String[] args) {
    Stream<Integer> streamOne = Stream.of(2, 3, 5, 7, 11, 13, 17, 19);
    Stream<Integer> streamTwo;

    // Method 1
//    streamTwo = streamOne.filter(innerClassInstance->{ return innerClassInstance>5 && innerClassInstance<15; });

    // Method 2 invalid, lambda invalid
//    streamTwo = streamOne.filter(innerClassInstance>5).filter(innerClassInstance<15);
    // Method 2 (valid, lambda corrected)
//    streamTwo = streamOne.filter(innerClassInstance -> innerClassInstance > 5).filter(innerClassInstance -> innerClassInstance < 15);

    /**
     * Method 3
     * Stream pipelines may execute either sequentially or in parallel. This execution mode is a property of the stream.
     * Streams are created with an initial choice of sequential or parallel execution.
     * (For example, Collection.stream() creates a sequential stream, and Collection.parallelStream() creates a parallel one.)
     * This choice of execution mode may be modified by the BaseStream.sequential() or BaseStream.parallel() methods.
     * It is not documented by Oracle exactly what happens when you change the stream execution mode multiple times in a pipeline.
     * It is not clear whether it is the last change that matters or whether operations invoked after calling () parallel can be
     * executed in parallel and operations invoked after calling sequential() will be executed sequentially.
     */
//    streamTwo = streamOne
//        .parallel()       // Stream pipelines may execute either sequentially or in parallel. This execution mode is a property of the stream.
//        .filter(innerClassInstance->innerClassInstance>5)
//        .filter(innerClassInstance->innerClassInstance<15)
//        .sequential();

    // Method 4 invalid (Keys in the Map produced by partitioningBy Collector are Boolean and not String. Hence get("true") will return null)
//    streamTwo = streamOne.collect(Collectors
//        .partitioningBy(innerClassInstance->{ return innerClassInstance>5 && innerClassInstance<15;}))
//        .get("true")
//        .stream();
    // Method 4 valid
    streamTwo = streamOne.collect(Collectors
        .partitioningBy(i->{ return i>5 && i<15;}))
        .get(true)
        .stream();


    // Prints result (which should be the same under all methods above)
    streamTwo.forEach(System.out::print);

  }

}
