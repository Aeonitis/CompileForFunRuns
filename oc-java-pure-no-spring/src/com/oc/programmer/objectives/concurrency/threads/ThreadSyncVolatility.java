package com.oc.programmer.objectives.concurrency.threads;

/**
 * Sample data:
 *
   * UnsyncedYetNotVolatile: x = 203465 , y = 203466 | Thread-0
   * UnsyncedYetNotVolatile: x = 203466 , y = 203467 | Thread-0
   * UnsyncedYetNotVolatile: x = 203444 , y = 203445 | Thread-1
   * UnsyncedYetNotVolatile: x = 203468 , y = 203469 | Thread-1
 *
 *
   * UnsyncedYetVolatile: x = 233791 , y = 233791 | Thread-0
   * UnsyncedYetVolatile: x = 233792 , y = 233792 | Thread-0
   * UnsyncedYetVolatile: x = 233757 , y = 233757 | Thread-1
   * UnsyncedYetVolatile: x = 233794 , y = 233794 | Thread-1
 *
 * Synchronized completely (volatile ints yield same results under synchronized method)
   * SyncedYetNotVolatile: x = 737957 , y = 737957 | Thread-0
   * SyncedYetNotVolatile: x = 737958 , y = 737958 | Thread-0
   * SyncedYetNotVolatile: x = 737959 , y = 737959 | Thread-1
   * SyncedYetNotVolatile: x = 737960 , y = 737960 | Thread-1
 *
 */
public class ThreadSyncVolatility {

  public static void main(String[] args) {
//    UnsyncedYetNotVolatile unsyncedYetNotVolatile = new UnsyncedYetNotVolatile();
//    new Thread(unsyncedYetNotVolatile).start();
//    new Thread(unsyncedYetNotVolatile).start();

//    UnsyncedYetVolatile unsyncedYetVolatile = new UnsyncedYetVolatile();
//    new Thread(unsyncedYetVolatile).start();
//    new Thread(unsyncedYetVolatile).start();
//
    SyncedYetNotVolatile syncedYetNotVolatile = new SyncedYetNotVolatile();
    new Thread(syncedYetNotVolatile).start();
    new Thread(syncedYetNotVolatile).start();
  }

}

class UnsyncedYetNotVolatile implements Runnable {

  volatile int x = 0, y = 0;

  public void run() {
    while (true) {
      x++;
      y++;
      System.out.println("UnsyncedYetNotVolatile: x = " + x + " , y = " + y + " | " + Thread.currentThread().getName());
    }
  }
}

class UnsyncedYetVolatile implements Runnable {

  volatile int x = 0, y = 0;

  public void run() {
    while (true) {
      x++;
      y++;
      System.out.println("UnsyncedYetVolatile: x = " + x + " , y = " + y + " | " + Thread.currentThread().getName());
    }
  }
}

class SyncedYetNotVolatile implements Runnable {

  volatile int x = 0, y = 0;

  public void run() {
    while (true) {
      synchronized (this) {
        x++;y++;
        System.out.println("SyncedYetNotVolatile: x = " + x + " , y = " + y + " | " + Thread.currentThread().getName());
      }
    }
  }
}