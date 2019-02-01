package com.oc.programmer.objectives.streams.functionalinterfaces;

import com.oc.programmer.objectives.arbitrarydata.SampleDataTypeGenerator;
import com.oc.programmer.objectives.arbitrarydata.entity.Game;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import java.util.List;
import java.util.stream.Stream;

/**
 * A Stream supports several operations and these operations are divided into intermediate and
 * terminal operations. The distinction between an intermediate operation and a termination
 * operation is that an intermediate operation is lazy while a terminal operation is not. When you
 * invoke an intermediate operation on a stream, the operation is not executed immediately. It is
 * executed only when a terminal operation is invoked on that stream. In a way, an intermediate
 * operation is memorized and is recalled as soon as a terminal operation is invoked. You can chain
 * multiple intermediate operations and none of them will do anything until you invoke a terminal
 * operation, at which time, all of the intermediate operations that you invoked earlier will be
 * invoked along with the terminal operation.
 *
 * Source: http://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html#StreamOps
 */
public class StreamIntermediateOperationConversion {

  public static void main(String[] args) {
    List<Game> gamesList = SampleDataTypeGenerator.getListOfGames();

    gamesList.forEach(x -> System.out.println(x.toString()));

    /**
     * Intermediate with no Terminal operations, does not print anything
     * Since the code does not invoke any terminal operation on the stream, the calls to these
     * intermediate method do nothing. Therefore, no output is produced.
     */
    gamesList.stream()
        .filter(game -> game.getTitle().startsWith("H"))
        .peek(game -> System.out.println(game.getTitle()))
        .map(game -> game.getTitle());

    /**
     * Intermediate with Terminal operations, prints successfully
     */
    gamesList.stream()
        .filter(game -> game.getTitle().startsWith("H"))
        .peek(game -> System.out.println(game.getTitle()))
        .map(game -> game.getTitle())
        .forEach(game -> System.out.println("Game is " + game));

    /**
     *  The call to map converts the stream of Games to a stream of Strings.
     *  The call to sorted() sorts the stream of String by their natural order.
     */
    gamesList.stream()
        .map((i) -> i.getTitle())
        .sorted()
        .forEach(gameString -> System.out
            .println("Game String title is " + gameString + (gameString instanceof String)));

    /**
     * It is easy to identify which operations are intermediate and which are terminal as intermediate
     * operations return Stream (that means, they can be chained), while terminal operations don't.
     * filter, peek, flatmap, map, distinct, sorted, limit and skip are intermediate operations.
     */
    System.out.println("ALL INTERMEDIATE OPERATIONS together");
    gamesList.stream()
        .peek(System.out::println)
        .map((i) -> i.getTitle())
        .flatMap(str -> Stream.of(str.split("[ ]")))
        .filter(i -> i.length()>1)
        .distinct()
        .sorted()
        .limit(10)
        .skip(0)
    .forEach(System.out::println);    // Terminal operation 'foreach' added just to instantiate all intermediate/lazy operations
  }
}
