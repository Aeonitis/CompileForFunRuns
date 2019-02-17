package com.oc.programmer.objectives.concurrency.threads;

/**
 * Which run() will be called?
 */
public class ThreadPoly {

  public static void main(String[] args) {
    Threader t = new Threader();
    Thread thread = new Pooler(t);
    thread.start();
  }
}

class Threader extends Thread {

  public Threader() {
    System.out.println("No-Arg Constructor of Threader.");
  }

  public Threader(Runnable runnable) {
    System.out.println("Constructor of Threader.");
  }

  public void run() {
    System.out.println("In Threader");
  }
}

class Pooler extends Thread {   //or extend Threader instead ;)

  public Pooler() {
  }

  public Pooler(Runnable runnable) {
    super(runnable);
    System.out.println("Constructor of Pooler.");
  }

  public void run() {
    System.out.println("In Pooler");
  }
}
