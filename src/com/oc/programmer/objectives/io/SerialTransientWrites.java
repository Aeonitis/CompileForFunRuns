package com.oc.programmer.objectives.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * - transient fields and static fields are never serialized.
 * - Constructor, instance blocks, and field initialization of the class being de-serialized are also not invoked.
 *
 * So, when boo is de-serialized, the value of transientInt is set to 0. The class Body is loaded as soon as
 * the code refers to the class (here, it happens at Body boo = new Body(); ), and so the static int staticInt is initialized to
 * the value given in the class code i.e. 20 and then it is incremented to 21 because of boo.staticInt++;.
 *
 * This part has nothing to do with serialization. So when you deserialize an instance of Body,
 * Body.staticInt is not affected and is not reset to 20.  Therefore, if you run the program again with just
 * the deserialization part, you will see that staticInt is 20 and not 21.
 */
public class SerialTransientWrites {

  public static void main(String[] args) throws Exception {
    Body body = new Body();
    body.staticInt++;

    printBodyParts(body);

    FileOutputStream fos = new FileOutputStream("c:\\temp\\body.ser");
    ObjectOutputStream os = new ObjectOutputStream(fos);
    os.writeObject(body);
    os.close();

    FileInputStream fis = new FileInputStream("c:\\temp\\body.ser");
    ObjectInputStream is = new ObjectInputStream(fis);
    body = (Body) is.readObject();
    is.close();

    printBodyParts(body);
  }

  public static void printBodyParts(Body body) {
    System.out.println(body.transientInt + " " + body.staticInt);
  }
}

class Body implements Serializable {

  transient int transientInt = 10;
  static int staticInt = 20;
}