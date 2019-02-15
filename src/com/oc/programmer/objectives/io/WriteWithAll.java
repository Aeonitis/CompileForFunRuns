package com.oc.programmer.objectives.io;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Source: https://www.baeldung.com/java-write-to-file
 * TODO: RandomAccessFile & FileChannel writes
 */
public class WriteWithAll {

  final static String VALID_DIR_PATH = "C:\\temp\\java\\io\\";

  public static void main(String[] args) throws IOException {

    writeWithFileOutputStream();
    writeWithPrintWriter();

    writeWithBufferedWriter_thenCorrect();
    writeWithBufferedWriter_thenOldContentShouldExistToo();

    writeWithDataOutputStream();
  }

  /**
   * Not O-Certification related
   * DataOutputStream available since Java 7 at least, for read and writes
   */
  public static void writeWithDataOutputStream() throws IOException {
    String valueWritten = "KHJLVLJYF^&*OR&(%^%*(PGYIFGLUYFO*^R%O*YGP*IGUOH*()_^T(&_%)*^$)$*^OFUIYHGLI*&^T)_(&%T";
    FileOutputStream fos = new FileOutputStream(VALID_DIR_PATH + "DataOutputStreamed");
    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
    outStream.writeUTF(valueWritten);
    outStream.close();

    // verify the results
    FileInputStream fis = new FileInputStream(VALID_DIR_PATH + "DataOutputStreamed");
    DataInputStream reader = new DataInputStream(fis);
    String resultReadBack = reader.readUTF();
    reader.close();

    System.out.println("Data verified: " + valueWritten.equals(resultReadBack));
  }

  /**
   * FileOutputStream to write binary data to a file. The following code converts a String int bytes
   *    * and writes the bytes to file using a FileOutputStream
   * @throws IOException
   */
  public static void writeWithFileOutputStream() throws IOException {
    String str = "Hello";
    FileOutputStream outputStream = new FileOutputStream(
        VALID_DIR_PATH + "FileOutputStreamwrotethis.note");
    byte[] strToBytes = str.getBytes();
    outputStream.write(strToBytes);

    outputStream.close();
  }

  /**
   * Note: we’re not only writing a raw String to file, but also some formatted text with the printf
   *    * method. We can create the writer using FileWriter, BufferedWriter or even System.out.
   * @throws IOException
   */
  public static void writeWithPrintWriter() throws IOException {
    FileWriter fileWriter = new FileWriter(VALID_DIR_PATH + "writeWithPrintWriter.txt");
    PrintWriter printWriter = new PrintWriter(fileWriter);
    printWriter.print("Some String");
    printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);

    printWriter.close();
  }

  public static void writeWithBufferedWriter_thenCorrect()
      throws IOException {
    String str = "Hello";
    BufferedWriter writer = new BufferedWriter(new FileWriter(VALID_DIR_PATH + "Helloworld.txt"));
    writer.write(str);

    writer.close();
  }

  public static void writeWithBufferedWriter_thenOldContentShouldExistToo()
      throws IOException {
    String str = "World";
    BufferedWriter writer = new BufferedWriter(
        new FileWriter(VALID_DIR_PATH + "Helloworld.txt", true));
    writer.append(' ');
    writer.append(str);

    writer.close();
  }
}
