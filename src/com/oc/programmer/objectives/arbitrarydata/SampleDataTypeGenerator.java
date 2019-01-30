package com.oc.programmer.objectives.arbitrarydata;

import com.oc.programmer.objectives.arbitrarydata.entity.Game;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SampleDataTypeGenerator {

  public static List getListOfGames() {
    return Arrays
        .asList(new Game("Portal 2", 10.0), new Game("Resident Evil 2", 5.0),
            new Game("Half Life 2", 5.0));
  }

  public static Stream getListOfGamesAsStream() {
    return getListOfGames().stream();
  }


}
