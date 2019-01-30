package com.oc.programmer.objectives.streams;

import com.oc.programmer.objectives.arbitrarydata.SampleDataTypeGenerator;
import com.oc.programmer.objectives.arbitrarydata.entity.Game;
import com.oc.programmer.objectives.streams.functionalinterfaces.PredicateImplementation;
import java.util.stream.Stream;

public class StreamFilter {

  static class GameFilter {

    public static boolean isPriced5orUnder(Game game) {
      return game.getPrice() <= 5;
    }

    public static void main(String[] args) {

      Stream<Game> gamesListStream = SampleDataTypeGenerator.getListOfGamesAsStream();

//    List<String> myList =
//        Arrays.asList("a1", "a2", "b1", "c2", "c1");
//
//    myList
//        .stream()
//        .filter(s -> s.startsWith("c"))
//        .map(String::toUpperCase)
//        .sorted()
//        .forEach(System.out::println);

      /**
       * All of the below 'filter' implementations work correctly
       */
      gamesListStream
          .filter((Game g) -> GameFilter.isPriced5orUnder(g))
          .filter(GameFilter::isPriced5orUnder)
          .filter(StreamFilter.GameFilter::isPriced5orUnder)
          .filter(PredicateImplementation::hasATitle)
          .forEach((Game g) -> System.out.println(g.getTitle()));
    }


  }


}