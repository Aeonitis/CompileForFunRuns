package com.oc.programmer.objectives.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegers {

  public static void main(String[] args) {
    AtomicInteger atomicInteger = new AtomicInteger(0);
    System.out.println("Initial Value:" + atomicInteger);

    System.out.println("getAndIncrement:" + atomicInteger.getAndIncrement() + "->" + atomicInteger);
    System.out.println("getAndDecrement:" + atomicInteger.getAndDecrement() + "->" + atomicInteger);

    System.out.println("incrementAndGet:" + atomicInteger.incrementAndGet() + "->" + atomicInteger);
    System.out.println("decrementAndGet:" + atomicInteger.decrementAndGet() + "->" + atomicInteger);

    System.out.println("getAndSet(n):" + atomicInteger.getAndSet(10) + "->" + atomicInteger);
    atomicInteger.set(2000);
    System.out.println("set(n), new value set to:" + atomicInteger);
    System.out.println("get():" + atomicInteger.get());

    System.out.println("addAndGet(n):" + atomicInteger.addAndGet(3) + "->" + atomicInteger);
    System.out.println("getAndAdd(n):" + atomicInteger.getAndAdd(2) + "->" + atomicInteger);

    // Invalid - AtomicInteger is not a wrapper class and so auto unboxing will not happen here and so it will not compile.
//    int integerOfAtomicInteger = atomicInteger + 1;

  }

}
