package com.oc.programmer.objectives.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * TODO: Not so clear-cut: https://enthuware.com/forum/viewtopic.php?f=2&t=3856
 */
public class FilesMoving {

  public static void main(String[] args) {
    differentFileAndDirEvenIfSameNameMoveTriggersNoSuchFileException();
  }

  /**
   * There are two contradictory factors at play here.
   *
   * 1. By default, Files.move method attempts to move the file to the target file, failing if the
   * target file exists except if the source and target are the same file, in which case this method
   * has no effect. Therefore, this code should throw an exception because 'differentFileAndDirEvenIfSameName.txt' exists in the
   * target directory.
   *
   * 2. However, when the CopyOption argument of the move method is StandardCopyOption.ATOMIC_MOVE,
   * the operation is implementation dependent if the target file exists. The existing file could be
   * replaced or an IOException could be thrown. If the exiting file at p2 is replaced,
   * Files.delete(p1) will throw java.nio.file.NoSuchFileException.
   */
  public static void differentFileAndDirEvenIfSameNameMoveTriggersNoSuchFileException() {
    Path originalFile = Paths.get("C:\\temp\\java\\nio\\differentFileAndDirEvenIfSameName.txt");
    Path differentFileAndDirEvenIfSameName = Paths.get("C:\\temp\\java\\nio\\alsoexistshere\\differentFileAndDirEvenIfSameName.txt");
    try {
      System.out.println("isSameFile: " + Files.isSameFile(originalFile, differentFileAndDirEvenIfSameName));
      Files.move(originalFile, differentFileAndDirEvenIfSameName, StandardCopyOption.ATOMIC_MOVE);
      Files.delete(originalFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Original File exists: " + originalFile.toFile().exists());
    System.out.println("differentFileAndDirEvenIfSameName exists: " + differentFileAndDirEvenIfSameName.toFile().exists());
  }

}
