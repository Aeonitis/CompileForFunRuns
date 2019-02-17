package com.oc.programmer.objectives.io.nio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Notes: 1. relativize method does not take a String as an argument. It takes a Path object. 2.
 * relativize method is meant to convert an absolute path into a relative path.
 *
 * Where this path and the given path do not have a root component, then a relative path can be
 * constructed.
 *
 * A relative path cannot be constructed if only one of the paths have a root component.
 *
 * Where both paths have a root component then it is implementation dependent if a relative path can
 * be constructed.
 *
 * If this path and the given path are equal then an empty path is returned.
 *
 * For any two normalized paths p and q, where q does not have a root component,
 * p.relativize(p.resolve(q)).equals(q)
 *
 * When symbolic links are supported, then whether the resulting path, when resolved against this
 * path, yields a path that can be used to locate the same file as other is implementation
 * dependent.
 *
 * For example, if this path is "/a/b" and the given path is "/a/x" then the resulting relative path
 * may be "../x". If "b" is a symbolic link then is implementation dependent if "a/b/../x" would
 * locate the same file as "/a/x".
 */
public class PathRelation {

  public static void main(String[] args) {
    Path p1 = Paths.get("x\\y");
    Path p2 = Paths.get("z");

    /**
     * Constructs a relative path between this path and a given path. Relativization is the inverse of resolution.
     * This method attempts to construct a relative path that when resolved against this path,
     * yields a path that locates the same file as the given path.
     *
     * For example, on UNIX, if this path is "/a/b" and the given path is "/a/b/c/d" then the resulting relative path would be "c/d".
     */
    Path p3 = p1.relativize(p2);
    System.out.println(p3);

    relativizingNonAbsolutePathThrowsException();
    resolveAndRelativize();
  }

  /**
   * This will throw an IllegalArgumentException saying 'other' is different type of Path. This is
   * because a relative path cannot be constructed if only one of the paths is an absolute path.
   * Here, p1 is an absolute path (because it starts with a root) and p2 is a relative path.
   */
  public static void relativizingNonAbsolutePathThrowsException() {
    Path p1 = Paths.get("c:\\temp\\test1.txt");
    try {
      p1.relativize(Paths.get("text2.txt"));
    } catch (IllegalArgumentException iae) {
      System.out.println("IllegalArgumentException: " + iae.getMessage());
    }
//    p1.relativize(Paths.get("text2.txt"));    // IllegalArgumentException: 'other' is different type of Path
  }

  public static void resolveAndRelativize() {
    Path originalRelativePath = Paths.get("\\slashes\\ok");
    Path slashPrefixPath = Paths.get("\\slashprefix");
    Path noSlashPrefixPath = Paths.get("noslashprefix");
    Path noslashpath = Paths.get("noslashpath");
    Path slashSuffixPath = Paths.get("slashsuffix\\");

    resolveAndPrint(originalRelativePath, slashPrefixPath);
    resolveAndPrint(originalRelativePath, noSlashPrefixPath);
    resolveAndPrint(originalRelativePath, slashSuffixPath);

    relativizeAndPrint(originalRelativePath, slashPrefixPath);
//    relativizeAndPrint(originalRelativePath, noSlashPrefixPath);  // IllegalArgumentException: 'other' is different type of Path
    relativizeAndPrint(noslashpath, noSlashPrefixPath);
//    relativizeAndPrint(originalRelativePath, slashSuffixPath);    // IllegalArgumentException: 'other' is different type of Path

    Path absolutePathWithCurrentAndBackAdded = Paths.get("c:\\zero\\.\\one\\..\\two.txt");
    Path absolutePathStandard = Paths.get("c:\\zero\\one.txt");
    relativizeAndPrint(absolutePathWithCurrentAndBackAdded, absolutePathStandard);
  }

  public static void relativizeAndPrint(Path originalPath, Path pathToRelativize) {
    System.out.println(
        "Result of relating '" + originalPath + "' to '" + pathToRelativize + "' is " + originalPath
            .relativize(pathToRelativize));
  }

  public static void resolveAndPrint(Path originalPath, Path pathToResolve) {
    System.out.println(
        "Result of resolving '" + originalPath + "' to '" + pathToResolve + "' is " + originalPath
            .resolve(pathToResolve));
  }
}


