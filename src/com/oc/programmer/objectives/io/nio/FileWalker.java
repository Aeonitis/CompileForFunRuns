package com.oc.programmer.objectives.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWalker {

  public static void main(String[] args) throws IOException {
    Files.walk(Paths.get("C:\\temp\\java\\"))
        .forEach(eachPath -> System.out.println(eachPath.toString() + "\n" + eachPath.toUri()));
  }

}
