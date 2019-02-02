package com.oc.programmer.objectives.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Moves the file fileOne.txt to fileTwo.txt, even if fileTwo.txt exists Note: Both files need to
 * exist for this to operate optimally or NoSuchFileException is thrown
 */
public class PathsFileReplacement {

  public static void main(String[] args) {
    Path p1 = Paths.get("c:\\temp\\fileOne.txt");
    Path p2 = Paths.get("c:\\temp\\fileTwo.txt");

    try {
      // Method 1
      Files.move(p1, p2, StandardCopyOption.REPLACE_EXISTING);

      // Method 2
      Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
      Files.delete(p1);

      /**
       * Methods 3/4
       * Note: that the exact file attributes that are copied is platform and file-system dependent and therefore unspecified
       * but last-modified-time is supported across platforms and is copied to the target file
       */
      Files.move(p1, p2, StandardCopyOption.COPY_ATTRIBUTES);
      Files.copy(p1, p2, StandardCopyOption.COPY_ATTRIBUTES);
      Files.delete(p1);

      /**
       *  Symbolic links are not followed. If the file is a symbolic link, then the symbolic link itself,
       *  not the target of the link, is copied. It is implementation specific if file attributes can be copied to the new link.
       *
       *  In other words, the COPY_ATTRIBUTES option may be ignored when copying a symbolic link.
       *  An implementation of this interface may support additional implementation specific options
       */
      System.out.println("Real path is: " + p1.toRealPath(LinkOption.NOFOLLOW_LINKS));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
