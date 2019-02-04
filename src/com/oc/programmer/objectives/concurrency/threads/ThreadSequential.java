package com.oc.programmer.objectives.concurrency.threads;

/**
 * Although two new threads are created but none of them is started.(Remember run() does not start a
 * thread. start() does.) Here, run is called but NOT of ThreadSequential class but of Thread class.
 */
public class ThreadSequential implements Runnable {

  String message = "default";

  public ThreadSequential(String string) {
    message = string;
  }

  public void run() {
    System.out.println(message);
  }

  /**
   * Thread class's run() is an interesting method. If the thread object was constructed using a separate
   * Runnable object, then that Runnable object's run method is called otherwise, this method does
   * nothing and returns. Here, Thread's run calls ThreadSequential's run() which prints the string and
   * returns. Everything is done in one thread (the main thread) and so the order is known.
   */
  public static void main(String args[]) {
    new Thread(new ThreadSequential("Runs first")).run();
    new Thread(new ThreadSequential("Runs second")).run();
    System.out.println("end");

    new Thread(new ThreadSequential("Runs")).start();
  }

}
