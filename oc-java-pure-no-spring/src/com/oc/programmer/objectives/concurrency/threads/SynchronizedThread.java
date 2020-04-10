package com.oc.programmer.objectives.concurrency.threads;

import java.util.Arrays;

/**
 * A thread acquires the intrinsic lock of an object when it enters synchronized method on that
 * object or when it enter a synchronized block that uses that object. The lock is not acquired when
 * a thread enters a non-synchronized method.
 *
 * When a synchronized method ends with a checked exception, the intrinsic lock held by the thread
 * is released automatically.
 *
 * Here, the access to shared variables x and y is in synchronized block, which is synchronizing on
 * the same (referred by infinityThread, which is also 'this') object. So, when any thread gets
 * access to the block it increments both x and y before the other thread can touch the block.
 *
 * This makes sure that the values of x and y are always same and they increase one by one.
 */
public class SynchronizedThread implements Runnable {

  int x = 0, y = 0;
  static boolean running = true;

  public void run() {
    while (running) {
      synchronized (this) {
        x++;
        y++;
        System.out.println(" x = " + x + " , y = " + y + " ~ " + Thread.currentThread().getName());

        stopRunningWhenVariableExceeds100(x);
        System.out.println("Current Thread state (insync): " + Thread.currentThread().getState());
      }
      System.out.println("Current Thread state (offsync): " + Thread.currentThread().getState());
    }
    System.out.println("Lock released by " + Thread.currentThread().getName());
  }

  public static void main(String[] args) {
    SynchronizedThread synchronizedThread = new SynchronizedThread();
    new Thread(synchronizedThread).start();
    new Thread(synchronizedThread).start();


    ThreadGroup currentThreadGroup = Thread.currentThread().getThreadGroup();
    int numberOfThreads = currentThreadGroup.activeCount();
    System.out.println("Threads currently running: " + numberOfThreads);
    Thread[] threadArray = new Thread[numberOfThreads];
    currentThreadGroup.enumerate(threadArray);
    Arrays.asList(threadArray).stream()
        .forEach(eachThread -> System.out.println("Thread name: " + eachThread.getName() + "|" + eachThread.getState()));

  }

  public static void stopRunningWhenVariableExceeds100(int intToCheck) {
    if (intToCheck == 600) {
      running = false;

    }
  }
}
