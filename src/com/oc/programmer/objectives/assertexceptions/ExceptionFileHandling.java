package com.oc.programmer.objectives.assertexceptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Most of the I/O operations (such as opening a stream on a file, reading or writing from/to a
 * file) throw IOException and this code does not handle IOException. FileNotFoundException is a
 * subclass of IOException and IndexOutOfBoundsException is subclass of RuntimeException. The code
 * can be fixed by replacing FileNotFoundException | IndexOutOfBoundsException with IOException or
 * by adding another catch block that catches IOException.
 */
public class ExceptionFileHandling {

  public static void copy(String records1, String records2) {
    try {
      InputStream is = new FileInputStream(records1);
      OutputStream os = new FileOutputStream(records2);
      byte[] buffer = new byte[1024];
      int bytesRead = 0;
      while ((bytesRead = is.read(buffer)) != -1) {
        os.write(buffer, 0, bytesRead);
        System.out.println("Read and written bytes " + bytesRead);
      }
    } catch (IOException | IndexOutOfBoundsException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    copy("c:\\temp\\test1.txt", "c:\\temp\\test2.txt");
  }
}