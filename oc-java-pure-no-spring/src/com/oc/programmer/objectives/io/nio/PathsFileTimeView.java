package com.oc.programmer.objectives.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class PathsFileTimeView {

  public static void main(String[] args) throws IOException {
    readFileAttributes();
  }

  public static void readFileAttributes() throws IOException {
    Path pathX = Paths.get("c:\\temp\\fileX.txt");

    BasicFileAttributeView view =
        Files.getFileAttributeView(pathX,BasicFileAttributeView.class);
    System.out.println("BasicFileAttributeView: " + view.name());

    BasicFileAttributes basicFileAttributes = view.readAttributes();
    System.out.println("SymLink: " + basicFileAttributes.isSymbolicLink());

    FileTime lastModifiedTime = FileTime.fromMillis(
        basicFileAttributes.lastModifiedTime().toMillis()+10_000);
    System.out.println("LastModifiedTime: " + lastModifiedTime);

    view.setTimes(lastModifiedTime,null,null);

  }
}
