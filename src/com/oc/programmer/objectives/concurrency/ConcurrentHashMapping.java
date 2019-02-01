package com.oc.programmer.objectives.concurrency;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Prints all key-value pairs of ConcurrentHashMap using keySet(), entrySet() via for-loop and iterator.
 */
public class ConcurrentHashMapping {

  public static void main(String[] args) {

    Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<String, Integer>();
    concurrentHashMap.put("Kindle", 99);
    concurrentHashMap.put("Samsung tablet", 200);
    concurrentHashMap.put("iPad", 1000);
    concurrentHashMap.put("iPad Mini", 600);

    System.out.println("All key/value pairs of ConcurrentHashMap");
    for (String key : concurrentHashMap.keySet()) {
      System.out.println("key: " + key + " : " + concurrentHashMap.get(key));
    }

    System.out.println("Printing all keys and values of ConcurrentHashMap");
    for (Map.Entry<String, Integer> entry : concurrentHashMap.entrySet()) {
      String key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println("key: " + key + " value: " + value);
    }

    System.out.println("Printing all keys/values of ConcurrentHashMap via Iterator with EntrySet");
    Set<Entry<String, Integer>> entrySet = concurrentHashMap.entrySet();
    Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
    while (entryIterator.hasNext()) {
      Map.Entry<String, Integer> entry = entryIterator.next();
      String key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println("key: " + key + " value: " + value);
    }

  }

}
