package com.oc.programmer.objectives.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileFinder {

  public static void main(String[] args) {
    findFileByName("lostfile.txt");
  }

  public static void findFileByName(String fileNameToSearch) {
    try {
      Stream<Path> pathStream = Files.find(
          Paths.get("C:\\temp\\java\\"),
          Integer.MAX_VALUE,
          (path, x) -> path.endsWith(fileNameToSearch) && x.isRegularFile());

      pathStream.forEach(System.out::println);

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
