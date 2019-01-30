package com.oc.programmer.objectives.streams.functionalinterfaces;

import com.oc.programmer.objectives.arbitrarydata.SampleDataTypeGenerator;
import com.oc.programmer.objectives.arbitrarydata.entity.Game;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class ConsumersBiConsumer {

  static List<Game> games = SampleDataTypeGenerator.getListOfGames();

  /**
   * Generates a Map<String, Double> from the List using Stream's collect method.
   * The Collectors.toMap method uses two functions to get two values from each element of the stream.  
   * The value returned by the first function is used as a key and the value returned by the
   * second function is used as a value to build the resulting Map.
   */
  static Map<String, Double> gamesMap = games.stream()
      .collect(Collectors.toMap((game -> game.getTitle()), game -> game.getPrice()));


  /**
   * This function is invoked for each entry, that is each key-value pair, in the map.
   * The first argument of this function is the key and the second is the value.
   */
  static BiConsumer<String, Double> funcPrintIfStartsWithLetter = (a, b) -> {
    if (a.startsWith("P")) {
      System.out.println(a);
      System.out.println(b);
    }
  };

  public static void main(String[] args) {

    /**
     * The forEach method of a Map requires a ConsumersBiConsumer.
     */
    gamesMap.forEach(funcPrintIfStartsWithLetter);

  }

}
