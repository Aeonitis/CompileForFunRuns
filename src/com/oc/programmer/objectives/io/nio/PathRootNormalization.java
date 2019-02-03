package com.oc.programmer.objectives.io.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Normalize method is implementation-dependent but in general it derives from the path, a path
 * that does not contain redundant name elements. In many file systems, the "." and ".." are special
 * names used to indicate the current directory and parent directory.
 *
 * In such file systems all occurrences of "." are considered redundant. If a ".." is preceded by a
 * non-".." name then both names are considered redundant (the process to identify such names is
 * repeated until it is no longer applicable).
 *
 * This method does not access the file system; the path may not locate a file that exists.
 * Eliminating ".." and a preceding name from a path may result in the path that locates a different
 * file than the original path. This can arise when the preceding name is a symbolic link.
 */
public class PathRootNormalization {

  public static void main(String[] args) {

    /**
     * At the top level and there is no parent directory at this level.
     * Therefore, it is redundant and is removed from the normalized path.
     * Had there been a parent directory for .., for example, c:/temp/../test.txt,
     * the parent directory and .. would cancel out ( i.e. the result would be c:/test.txt ).
     */
    Path pathOne = Paths.get("c:\\..\\temp\\test.txt");
    System.out.println(pathOne);
    System.out.println(pathOne.normalize());
    System.out.println(pathOne.normalize().toUri());

    Path pathTwo = Paths.get("c:\\.\\temp\\test.txt");
    System.out.println(pathTwo);
    System.out.println(pathTwo.normalize());
    System.out.println(pathTwo.normalize().toUri());
  }

}
