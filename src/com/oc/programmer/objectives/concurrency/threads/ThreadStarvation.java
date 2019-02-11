package com.oc.programmer.objectives.concurrency.threads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Starvation occurs when one thread cannot access the CPU because one or more other threads are
 * monopolizing the CPU. Thread starvation may be caused because of different thread priorities.
 *
 * A lower-priority thread can be starved by higher-priority threads if the higher-priority threads
 * do not yield control of the CPU from time to time.
 *
 * Starvation can occur due to the following reasons:
 * - Threads are blocked infinitely because a "greedy" thread takes long time to execute some synchronized code (e.g. heavy I/O operations or infinite loop).
 * - A thread does not get CPU’s time for execution because it has low priority as compared to other threads which have higher priority.
 * - Threads are waiting on a resource forever but they remain waiting forever because other threads are constantly notified instead of the hungry ones.
 */
public class ThreadStarvation {

  public static void main(String[] args) {
    Worker worker = new Worker();

    for (int i = 0; i < 10; i++) {

      //new Thread(() -> worker.work()).start();  // Alternate lambda way also works
      new Thread(new Runnable() {
        public void run() {
          worker.work();
        }
      }).start();

    }
  }

}

class Worker {

  public synchronized void work() {
    String name = Thread.currentThread().getName();
    String fileName = name + ".txt";

    try (
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    ) {
      writer.write("Thread " + name + " wrote this mesasge");
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    while (true) {
      System.out.println(name + " is working");

      /**
       * Waiting on the current thread can resolve this starvation issue, holding for a specified amount
       * of time so other threads have chance to acquire the lock on the Worker object
       */
      //try {
      //  wait(1000);
      //} catch (InterruptedException ex) {
      //  ex.printStackTrace();
      //}

    }
  }
}