package com.oc.programmer.objectives.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * From a ReadWriteLock, you can get one read readWriteLock (by calling readWriteLock.readLock()) and one write readWriteLock
 * (by calling readWriteLock.writeLock()). Even if you call these methods multiple times, the same readWriteLock is
 * returned.
 *
 * A read readWriteLock can be locked by multiple threads simultaneously (by calling readWriteLock.readLock().readWriteLock()),
 * if the write readWriteLock is free.
 *
 * If the write readWriteLock is not free, a read readWriteLock cannot be locked.
 * The write readWriteLock can be locked (by calling readWriteLock.writeLock().readWriteLock()) only by only
 * one thread and only when no thread already has a read readWriteLock or the write readWriteLock.
 *
 * In other words, if one thread is reading, other threads can read, but no thread can write.
 * If one thread is writing, no other thread can read or write.
 *
 * Methods that do not modify the collection (i.e. the threads that just "read" a collection) should
 * acquire a read readWriteLock and threads that modify a collection should acquire a write readWriteLock.
 *
 * The benefit of this approach is that multiple reader threads can run without blocking if
 * the write readWriteLock is free. This increases performance for read only operations.
 */
public class LockReadWrite {

  private Map<String, Integer> marksObtained = new HashMap<>();
  private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

  public static void main(String[] args) {

    final LockReadWrite lockReadWrite = new LockReadWrite();

    create1ThreadToAddMarks(lockReadWrite);
    create5ThreadsToGetAverage(lockReadWrite);

  }

  private static void create1ThreadToAddMarks(LockReadWrite lockReadWrite) {
    new Thread() {
      public void run() {
        int x = 0;
        while (true) {
          int m = (int) (Math.random() * 100);
          lockReadWrite.setMarksInSubject("Sub " + x, m);
          x++;
        }
      }
    }.start();
  }

  private static void create5ThreadsToGetAverage(LockReadWrite lockReadWrite) {
    for (int i = 0; i < 5; i++) {
      new Thread() {
        public void run() {
          while (true) {
            double averageMarks = lockReadWrite.getAverageMarks();
            System.out.println(averageMarks);
          }
        }
      }.start();
    }
  }

  public void setMarksInSubject(String subject, Integer marks) {
//    System.out.println(readWriteLock.writeLock().tryLock());
    readWriteLock.writeLock().lock(); //1
    try {
      marksObtained.put(subject, marks);
    } finally {
      readWriteLock.writeLock().unlock(); //2
    }
  }

  public double getAverageMarks() {
    readWriteLock.readLock().lock(); //3
    double sum = 0.0;
    try {
      for (Integer mark : marksObtained.values()) {
        sum = sum + mark;
      }
      return sum / marksObtained.size();
    } finally {
      readWriteLock.readLock().unlock();//4
    }
  }


}
