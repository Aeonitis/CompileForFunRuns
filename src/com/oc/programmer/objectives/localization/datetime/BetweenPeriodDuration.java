package com.oc.programmer.objectives.localization.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;

/**
 * Sample result, difference between both between results
 * P-3Y-5M-2D
 * PT-30004H-31M-23.783S
 */
public class BetweenPeriodDuration {

  public static void main(String[] args) {
    Period p = Period
        .between(LocalDate.now(), LocalDate.of(2015, Month.SEPTEMBER, 1)); System.out.println(p);

    Duration d = Duration.between(
        LocalDateTime.now(),
        LocalDateTime.of(2015, Month.SEPTEMBER, 2, 10, 10)); System.out.println(d);
  }

}
