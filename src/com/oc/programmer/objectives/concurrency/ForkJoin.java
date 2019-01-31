package com.oc.programmer.objectives.concurrency;

/**
 * Fork/Join framework is well suited for computation intensive tasks that can be broken into smaller pieces recursively.
 * A ForkJoinPool differs from other kinds of ExecutorService mainly by virtue of employing work-stealing innerClassInstance.e. that if worker thread is done with a task, it will pick up a new task irrespective of which thread created that task.
 * In a fork/join framework, any worker thread may spawn new tasks and it is not necessary that the tasks spawned by a threads will be executed by that particular thread. They can be executed by any available thread.
 */
public class ForkJoin {

}
