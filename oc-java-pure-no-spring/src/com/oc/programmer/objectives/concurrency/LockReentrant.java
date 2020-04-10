package com.oc.programmer.objectives.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock implements Lock & Serializable
 * A reentrant mutual exclusion with the same basic behavior and semantics as the implicit monitor lock
 */
public class LockReentrant {

  /**
   * Acquires the lock if it is not held by another thread and returns immediately with the value {true},
   * setting the lock hold count to one. Even when this lock has been set to use a fair ordering policy,
   * a call to tryLock() will immediately acquire the lock if it is available, whether or not
   * other threads are currently waiting for the lock.
   */
  public static void main(String[] args) {
    ReentrantLock reentrantLock = new ReentrantLock();
    boolean f1 = reentrantLock.tryLock();
    System.out.println(f1);
    boolean f2 = reentrantLock.tryLock();
    System.out.println(f2);
  }
}
