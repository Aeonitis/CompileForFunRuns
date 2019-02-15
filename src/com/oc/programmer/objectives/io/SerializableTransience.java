package com.oc.programmer.objectives.io;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Method 1
 * 2 Approaches can be taken independent of each other so that a Portfolio object can be serialized
 * while preserving the state of the Bond objects contained in Portfolio
 */
public class SerializableTransience {

  public static void main(String[] args) throws Exception {
    Portfolio portfolio = new Portfolio();
    // get portfolio somehow.
    // serialize portfolio
  }
}

/**
 * Method 1
 * Class implements Serializable
 */
//class Bond implements Serializable {
//
//  String ticker;
//  double coupon;
//  Date maturity;
//}


/**
 * Method 2
 * Make bonds array transient in Portfolio and implement readObject(ObjectInputStream os) and
 * writeObject(ObjectOutputStream os)  methods to read and write the state of Bond objects explicitly
 */
class Bond {

  String ticker;
  double coupon;
  Date maturity;
}

class Portfolio implements Serializable {

  String accountName;
  transient Bond[] bonds = new Bond[]{ }; // must be transient because Bond class does not implement Serializable

  private void writeObject(ObjectOutputStream os) throws Exception {
    os.defaultWriteObject();
    os.writeInt(bonds.length);
    //write the state of bond objects
    for (int i = 0; i < bonds.length; i++) {
      os.writeObject(bonds[i].ticker);
      os.writeDouble(bonds[i].coupon);
      os.writeObject(bonds[i].maturity);
    }
  }

  private void readObject(ObjectInputStream os) throws Exception {
    os.defaultReadObject();
    int n = os.readInt();
    this.bonds = new Bond[n];
    //read the state of bond objects.
    for (int i = 0; i < bonds.length; i++) {
      bonds[i] = new Bond();
      bonds[i].ticker = (String) os.readObject();
      bonds[i].coupon = os.readDouble();
      bonds[i].maturity = (java.util.Date) os.readObject();
    }

  }
}