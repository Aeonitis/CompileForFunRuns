package com.oc.programmer.objectives.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * There are no guarantees beyond best-effort attempts to stop processing actively executing tasks.
 * For example, typical implementations will cancel via Thread.interrupt(), so any task that fails to respond to interrupts may never terminate.
 */
public class FutureCall {

  public static void main(String[] args) throws Exception {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<String> future = executorService.submit(new MyCallable());

    System.out.println(future.isCancelled());
    System.out.println(future.isDone());

    /**
     * Future.get() will block until there is a value to return or there is an exception
     * It will print the return value of the given Callable once it is done.
     * If you don't want to block the code, you may use Future.isDone(), which returns a boolean without blocking.
     */
    System.out.println(future.get());

    System.out.println(future.isCancelled());
    System.out.println(future.isDone());

    // This method attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.
    executorService.shutdownNow();

    // Note: awaitTermination() does not wait for actively executing tasks to terminate.
  }
}


class MyCallable implements Callable<String> {

  public String call() throws Exception {
    Thread.sleep(10000);
    return "DONE";
  }
}