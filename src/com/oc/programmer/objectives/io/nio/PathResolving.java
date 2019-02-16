package com.oc.programmer.objectives.io.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * If the other parameter is an absolute path then this method trivially returns other.
 *
 * If other is an empty path then this method trivially returns this path. Otherwise this method
 * considers this path to be a directory and resolves the given path against this path.
 *
 * In the simplest case, the given path does not have a root component, in which case this method
 * joins the given path to this path and returns a resulting path that ends with the given path.
 *
 * Where the given path has a root component then resolution is highly implementation dependent and
 * therefore unspecified.
 */
public class PathResolving {

  public static void main(String[] args) {

    Path thisPath;
    Path otherPath;

    // If the other parameter is an absolute path then this method trivially returns OTHER.
    thisPath = Paths.get("c:\\temp\\test.txt");
    otherPath = Paths.get("c:\\temp\\report.pdf");
    System.out.println("Other is absolute: " + thisPath.resolve(otherPath));

    // If the other parameter is not an absolute path then this method trivially returns OTHER.
    thisPath = Paths.get("c:\\temp\\test.txt");
    otherPath = Paths.get("\\temp\\report.pdf");
    System.out.println("Other is not absolute: " + thisPath.resolve(otherPath));

    // If other is an empty path then this method trivially returns THIS path.
    thisPath = Paths.get("c:\\temp\\test.txt");
    otherPath = Paths.get("");    // If null, not same result, just NullPointerException
    System.out.println("Other is empty: " + thisPath.resolve(otherPath));

    // If the other parameter is an absolute path then this method trivially returns other.
    thisPath = Paths.get("c:\\temp\\test.txt");
    otherPath = Paths.get("c:\\temp\\report.pdf");
    System.out.println("Other is directory: " + thisPath.resolve(otherPath));

    resolveSibling();
    resolveSiblingRelativePathJustAddsToRoot();
  }

  public static void resolveSibling() {
    Path p1 = Paths.get("C:\\temp\\java\\nio\\PathResolving.txt");
    Path p2 = p1.resolveSibling("PathResolving-resolveSibling.txt");
    System.out.println(p2);
  }

  public static void resolveSiblingRelativePathJustAddsToRoot() {
    Path p1 = Paths.get("C:\\temp\\java\\nio\\PathResolving.txt");
    Path p2 = p1.resolveSibling("\\DELETETHIS");
    System.out.println(p2);
  }
}
