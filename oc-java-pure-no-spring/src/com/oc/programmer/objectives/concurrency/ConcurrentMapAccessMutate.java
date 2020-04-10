package com.oc.programmer.objectives.concurrency;

import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  Tests two accessing threads and one mutating the shared instance of ConcurrentHashMap
 */
public class ConcurrentMapAccessMutate {

  private final Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
  private final static int MAX_MAP_SIZE = 150;

  public static void main(String[] args) {
    new ConcurrentMapAccessMutate().run();
  }

  public ConcurrentMapAccessMutate() {
    System.out.println("Creating concurrentHashMap...");
    for (int i = 0; i < MAX_MAP_SIZE; i++) {
      concurrentHashMap.put("key" + i, UUID.randomUUID().toString());
    }
    System.out.println("Finished creating concurrentHashMap...");
  }

  private final ExecutorService executorService = Executors.newCachedThreadPool();

  private final class MapAccessor implements Runnable {

    private final Map<String, String> map;

    public MapAccessor(Map<String, String> map) {
      this.map = map;
    }

    @Override
    public void run() {
      System.out.println("Starting access to concurrentHashMap with thread: " + Thread.currentThread().getName());
      for (Map.Entry<String, String> entry : this.map.entrySet()) {
        System.out.println("accessed ~ " +
            Thread.currentThread().getName() + " - [" + entry.getKey() + ", " + entry.getValue()
                + ']'
        );
      }
    }
  }

  private final class MapMutator implements Runnable {

    private final Map<String, String> map;
    private final Random random = new Random();

    public MapMutator(Map<String, String> map) {
      this.map = map;
    }

    @Override
    public void run() {
      System.out.println("Starting mutation to concurrentHashMap with thread: " + Thread.currentThread().getName());
      for (int i = 0; i < 100; i++) {
        this.map.remove("key" + random.nextInt(MAX_MAP_SIZE));
        this.map.put("key" + random.nextInt(MAX_MAP_SIZE), UUID.randomUUID().toString());
        System.out.println("mutating ~ " +
            Thread.currentThread().getName() + ": " + i);
      }
    }
  }

  private void run() {
    MapAccessor mapAccessorOne = new MapAccessor(this.concurrentHashMap);
    MapAccessor mapAccessorTwo = new MapAccessor(this.concurrentHashMap);
    MapMutator mapMutator = new MapMutator(this.concurrentHashMap);

    executorService.execute(mapAccessorOne);
    executorService.execute(mapMutator);
    executorService.execute(mapAccessorTwo);
  }
}