package com.oc.programmer.objectives.io.nio;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsNormalizeRelativize {

  public static void main(String[] args) throws IOException {
    Path pathBear = Paths.get("/user/.././root", "../bear.txt");
    Path pathLion = Paths.get("/lion");

    System.out.println(pathBear);
    System.out.println(pathLion);
    pathBear.normalize().relativize(pathLion);
    System.out.println(pathBear.toRealPath(LinkOption.NOFOLLOW_LINKS));
  }


}
