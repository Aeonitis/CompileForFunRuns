package com.oc.programmer.objectives.assertexceptions;

import java.io.IOException;

public class ExceptionSuppressionConstructor implements AutoCloseable{

  String header = null;

  public static void main(String[] args) throws Exception {
    try (ExceptionSuppressionConstructor constructorX = new ExceptionSuppressionConstructor("X");
        ExceptionSuppressionConstructor constructorY = new ExceptionSuppressionConstructor("Y")) {
      throw new Exception("test");
    }
  }

  public ExceptionSuppressionConstructor(String name) throws IOException {
    header = name;
    if ("Y".equals(name)) {
      System.out.println("IO issue while constructing ~ " + header);
      throw new IOException("IO oh oh");
    }
    System.out.println(header + " Opened");
  }

  public String read() throws IOException {
    return "";
  }

  public void close() {
    System.out.println("Runtime issue while closing ~ " + header);
    throw new RuntimeException("RuntimeException while closing " + header);
  }

}
