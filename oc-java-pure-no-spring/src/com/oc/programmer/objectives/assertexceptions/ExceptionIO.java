package com.oc.programmer.objectives.assertexceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionIO {

  public static void main(String[] args) {
    /**
     * Note: BufferedReader.close (which is called automatically at the end of the try-with-resources block) and BufferedReader.readLine methods throws java.io.IOException
     */
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("c:\\temp\\fileX.txt"))) {
      String line = null;
      while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.out.println("IOException thrown: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
