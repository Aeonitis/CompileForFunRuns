package com.oc.programmer.objectives;

import java.util.Optional;

public class OptionalFunctions {

  public static Optional<String> getScore(int marks) {
    Optional<String> score = Optional.empty();
    if (marks > 50) {
      score = Optional.of("PASS");
    } else {
      score.of("FAIL");
    }
    return score;
  }

  public static void main(String[] args) {
    Optional<String> scoreOne = getScore(50);
    Optional<String> scoreTwo = getScore(55);

    /**
     * Optional has a static method named of(T t) that returns an Optional object containing the value passed as argument.
     * It will throw NullPointerException if you pass null unless you use Optional.ofNullable(T t) method.
     * This will return Optional.empty if you pass null
     */
//    System.out.println(Optional.of(null));  // Invalid - NullPointerException
    System.out.println(Optional.ofNullable(null));                // Optional.empty since nullable
    System.out.println(Optional.of("optionalOfString"));

    System.out.println("current scoreOne: " + scoreOne);
    System.out.println("current scoreTwo: " + scoreTwo);

//    System.out.println(scoreOne.get());     // Invalid - NoSuchElementException: No value present
    System.out.println("scoreTwo.get(): " + scoreTwo.get());

    /**
     * You cannot change the contents of Optional object after creation. Optional does not have a set method.
     * Therefore, score.of, although technically correct, will not actually change the Optional object referred to by score.
     * It will return a new Optional object containing the passed argument.
     */
    //TODO show the above in sample, compare hashcodes or something :P

    /**
     *  The orElse method returns the actual object contained inside the Optional or
     *  the argument passed to this method if the Optional is empty.
     *  It does not return an Optional object.
     *  Therefore, print(scoreOne.orElse("UNKNOWN")) will print UNKNOWN and not Optional[UNKNOWN].
     */
    System.out.println(scoreOne.orElse("'orElse' Scenario"));

    System.out.println(Optional.empty().orElse("'orElse' Scenario"));

    /**
     * isPresent() returns true if the Optional contains a value, false otherwise.
     * ifPresent(Consumer ) executes the Consumer object with the value if the Optional contains a value.
     * Not that it is the value contained in the Optional that is passed to the Consumer and not the Optional itself.
     */
    if (scoreTwo.isPresent()) {
      scoreTwo.ifPresent(
          s -> System.out
              .println("Executed with the value, not the wrapping Optional, hence type String: "
                  + (s.equals("PASS") && !s.equals("Optional[PASS]") && (s instanceof String))));
    } else {
      System.out.println(scoreTwo.orElse("'orElse' Scenario"));
    }
  }

}
