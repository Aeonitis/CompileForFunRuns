package com.oc.programmer.objectives.assertexceptions;

import java.io.IOException;

/**
 * If an exception is thrown within the try-with-resources block, then that is the exception that
 * the caller gets. But before the try block returns, the resource's close() method is called and if
 * the close() method throws an exception as well, then this exception is added to the original
 * exception as a suppressed exception.
 */
public class ExceptionSuppressed implements AutoCloseable {

  String header = null;

  public static void main(String[] args) throws Exception {
    try (ExceptionSuppressed exceptionSuppressed = new ExceptionSuppressed()) {
      System.out.println("Throwing Exception!");
      throw new Exception("test");
    }
  }

  public void open() throws IOException {
    header = "OPENED";
    System.out.println("Opening... throwing IOException");
    throw new IOException("Unknown");
  }

  public String read() throws IOException {
    return "";
  }

  public void close() {
    System.out.println("Closing... throwing RuntimeException...");
    header = null;
    throw new RuntimeException("rte");
  }
}
