package com.oc.programmer.objectives.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Objective: run method of TaskRunnable will only be executed after the taskThread started and the
 * main thread have both invoked await
 *
 * A CyclicBarrier allows multiple threads to run independently but wait at one point until all of
 * the coordinating threads arrive at that point. Once all the threads arrive at that point, all the
 * threads can then proceed.
 *
 * It is like multiple cyclists taking different routes to reach a particular junction.
 * They may arrive at different times but they will wait there until everyone arrives.
 * Once everyone is there, they can go on further independent of each other.
 */
public class CyclicBarrierThread {

  public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
    TaskRunnable taskRunnable = new TaskRunnable();

    /**
     * Since there are a total two threads that are calling 
     * cb.await ( one is the TaskThread thread and another one is the main thread),
     * you need to create a CyclicBarrier with number of parties parameter as 2. 
     *
     * parties = the number of threads that must invoke await before the barrier is tripped
     *
     * If you specify the number of parties parameter as 1, TaskRunnable's run will be invoked as soon as any thread invokes await but that is not what the problem statement wants.
     */
    CyclicBarrier cyclicBarrier = new CyclicBarrier(2, taskRunnable);

    TaskThread taskThread = new TaskThread(cyclicBarrier);
    taskThread.start();
    System.out.println("CyclicBarrier await @Main");
    cyclicBarrier.await();
  }
}

class TaskThread extends Thread {

  CyclicBarrier cb;

  public TaskThread(CyclicBarrier cb) {
    this.cb = cb;
  }

  public void run() {
    System.out.println("TaskThread starting...");
    try {
      System.out.println("CyclicBarrier await @TaskThread");
      cb.await();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

class TaskRunnable implements Runnable {

  public void run() {
    System.out.println("TaskRunnable running...");
  }
}