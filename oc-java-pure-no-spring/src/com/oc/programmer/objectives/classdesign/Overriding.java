package com.oc.programmer.objectives.classdesign;


/**
 * This question illustrates the fundamental aspect of overriding, which is that it is the actual
 * class of object and not the class of the reference type that determines which instance method
 * will be invoked. Here, actual class of the object pointed to by 'human' is GoodHuman and therefore
 * GoodHuman's doHumanStuff will be invoked. This method prints the data field, which brings us to
 * the second important concept.  
 * 
 * Access to fields (and static methods) is bound at compile time and is never polymorphic.
 * That is why if a field (or a static method) by the same name is defined in the base class as
 * well as the derived class, it is class of the reference (and not the class of the actual object) that
 * determines which field will be accessed. Here, the variable used to access data field is
 * "this" (which is implicit) and it is of type GoodHuman and therefore GoodHuman's data field will be used.
 */
public class Overriding {

  public static void main(String[] args) {
    Human human = new GoodHuman();
    human.doHumanStuff();
  }
}

abstract class Human {

  String data = "Human data";

  public void doHumanStuff() {
  }
}

class GoodHuman extends Human {

  String data = "Good Human data";

  public void doHumanStuff() {
    System.out.println(data);
  }
}