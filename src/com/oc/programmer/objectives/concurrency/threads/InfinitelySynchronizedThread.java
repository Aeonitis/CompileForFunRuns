package com.oc.programmer.objectives.concurrency.threads;

/**
 * Here, the access to shared variables x and y is in synchronized block, which is synchronizing on
 * the same (referred by infinityThread, which is also 'this') object. So, when any thread gets access to the
 * block it increments both x and y before the other thread can touch the block.
 *
 * This makes sure that the values of x and y are always same and they increase one by one.
 */
public class InfinitelySynchronizedThread implements Runnable {

  int x = 0, y = 0;

  public void run() {
    while (true) {
      synchronized (this) {
        x++;
        y++;
        System.out.println(" x = " + x + " , y = " + y);
      }
    }
  }

  public static void main(String[] args) {
    InfinitelySynchronizedThread infinitelySynchronizedThread = new InfinitelySynchronizedThread();
    new Thread(infinitelySynchronizedThread).start();
    new Thread(infinitelySynchronizedThread).start();
  }
}
