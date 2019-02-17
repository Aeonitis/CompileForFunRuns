package com.oc.programmer.objectives.concurrency;

/**
 * ExecutorService — a single-threaded executor. It uses one thread to handle all incoming tasks. Of
 * course, you can customize your ExecutorService in a wide variety of ways or use one of the
 * factory methods from the Executors class:
 *
 * newCachedThreadPool() — creates an ExecutorService that creates new threads as needed and reuses
 * existing threads to handle incoming tasks.
 *
 * newFixedThreadPool(int numberOfThreads) — creates an ExecutorService that reuses a fixed number of threads.
 *
 * newScheduledThreadPool(int corePoolSize) — creates an ExecutorService that schedules commands to
 * run after a given delay (or to execute periodically).
 *
 * newSingleThreadExecutor() — creates an ExecutorService that uses a single worker thread.
 *
 * newSingleThreadScheduledExecutor() — creates a single-threaded ExecutorService that
 * schedules commands to run after a given delay (or to execute periodically).
 *
 * newWorkStealingPool() — creates an ExecutorService that uses multiple task queues to reduce contention.
 */
public class Execution {

}
