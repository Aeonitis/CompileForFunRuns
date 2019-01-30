package com.oc.programmer.objectives.streams.functionalinterfaces;

import com.oc.programmer.objectives.arbitrarydata.entity.Game;
import java.util.function.Predicate;

public class PredicateImplementation implements Predicate<Game> {

  /**
   * Mandatory test function as part of implementation
   * TODO: Get better use case for test
   */
  @Override
  public boolean test(Game game) {
    return !game.getTitle().isEmpty();
  }

  public static boolean hasATitle(Game game) {
    return !game.getTitle().isEmpty();
  }
}
