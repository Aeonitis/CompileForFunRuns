package com.oc.programmer.objectives.io.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesStandardCopier {

  public static void copy1(Path p1, Path p2) throws Exception {
    Files.copy(p1, p2, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
  }

  public static void main(String[] args) throws Exception {
    Path p1 = Paths.get("C:\\temp\\java\\nio\\yin.txt");
    Path p2 = Paths.get("C:\\temp\\java\\nio\\yang.txt");
    copy1(p1, p2);
    if (Files.isSameFile(p1, p2)) {
      System.out.println("file copied");
    } else {
      System.out.println("unable to copy file");
    }
  }
}
