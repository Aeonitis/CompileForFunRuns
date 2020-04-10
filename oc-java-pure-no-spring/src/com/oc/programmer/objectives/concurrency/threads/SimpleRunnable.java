package com.oc.programmer.objectives.concurrency.threads;

/**
 * Both the threads are trying to use the same variable.
 *
 * Now, which thread will run first cannot be determined so whether the main() thread reads 'myVolatileInt' first or
 * the new thread changes 'myVolatileInt' first is not known.
 *
 * Output of this program cannot be determined.
 */
public class SimpleRunnable implements Runnable {

  /**
   * The Java volatile keyword is used to mark a Java variable as "being stored in main memory".
   * Every read of a volatile variable will be read from the computer's main memory, and not from the CPU cache,
   * and that every write to a volatile variable will be written to main memory, and not just to the CPU cache.
   */
  volatile int myVolatileInt;

  public void run() {
    System.out.println("running after or before int prints?");
    myVolatileInt = 5;
  }

  // Two threads here, main() thread and the thread started
  public static void main(String[] args) {
    SimpleRunnable simpleRunnable = new SimpleRunnable();
    simpleRunnable.myVolatileInt = 10;

    new Thread(simpleRunnable).start();
    System.out.println(simpleRunnable.myVolatileInt);
  }
}