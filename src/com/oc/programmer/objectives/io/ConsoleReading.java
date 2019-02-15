package com.oc.programmer.objectives.io;

import java.io.Console;

public class ConsoleReading {

//  public static void main(String[] args) {
//    Console c=System.console();
//    System.out.println("Enter password: ");
//    char[] ch=c.readPassword();
//    String pass=String.valueOf(ch);//converting char array into string
//    System.out.println("Password is: "+pass);
//  }

  public static void main(String[] args) {
    Console cnsl = null;
    String name = null;

    try {
      // creates a console object
      cnsl = System.console();

      // if console is not null
      if (cnsl != null) {
        // read line from the user input
        name = cnsl.readLine("Name: ");

        // prints
        System.out.println("Name entered : " + name);
      }

    } catch (Exception ex) {
      // if any error occurs
      ex.printStackTrace();
    }
  }
}