package com.oc.programmer.objectives.io.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
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
 * For example, if this path is "/a/b" and the given path is "/a/x" then the resulting
 * relative path may be "../x". If "b" is a symbolic link then is implementation dependent if
 * "a/b/../x" would locate the same file as "/a/x".
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
  }
}


