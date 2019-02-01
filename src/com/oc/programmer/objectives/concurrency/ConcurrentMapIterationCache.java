package com.oc.programmer.objectives.concurrency;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * An important thing to know about the Iterators retrieved from a ConcurrentHashMap is that they
 * are backed by that ConcurrentHashMap, which means any operations done on the ConcurrentHashMap
 * instance may be reflected in the Iterator.
 *
 * Thus, in this case, the thread that is iterating through the entries may or may not see the
 * entries removed from the map by another thread. The following is what JavaDoc API description
 * says about ConcurrentHashMap:
 *
 * Retrieval operations (including get) generally do not block, so may overlap with update
 * operations (including put and remove). Retrievals reflect the results of the most recently
 * completed update operations holding upon their onset. For aggregate operations such as putAll and
 * clear, concurrent retrievals may reflect insertion or removal of only some entries. Similarly,
 * Iterators and Enumerations return elements reflecting the state of the hash table at some point
 * at or since the creation of the iterator/enumeration. They do not throw ConcurrentModificationException.
 * However, iterators are designed to be used by only one thread at a time.
 *
 * NOTE:
 * Each iterator you obtain from a ConcurrentHashMap is designed to be used by a single thread and should not be passed around.
 * Sharing the same iterator between accessor threads can lead to deadlock
 */
public class ConcurrentMapIterationCache {

  static ConcurrentHashMap<String, Object> stringObjectConcurrentHashMap = new ConcurrentHashMap<String, Object>();

  public static void main(String[] args) {
    stringObjectConcurrentHashMap.put("a", "aaa");
    stringObjectConcurrentHashMap.put("b", "bbb");
    stringObjectConcurrentHashMap.put("c", "ccc");

    /**
     * The following is the behaviour description of the EntrySet retrieved from a ConcurrentHashMap
     * instance using the entrySet() method:
     *
     * entrySet() returns a Set view of the mappings contained in this map. The set is backed by the
     * map, so changes to the map are reflected in the set, and vice-versa. The set supports element
     * removal, which removes the corresponding mapping from the map, via the Iterator.remove,
     * Set.remove, removeAll, retainAll, and clear operations. It does not support the add or addAll
     * operations.
     *
     * The view's iterator is a "weakly consistent" iterator that will never throw
     * ConcurrentModificationException, and guarantees to traverse elements as they existed upon
     * construction of the iterator, and may (but is not guaranteed to) reflect any modifications
     * subsequent to construction.
     */
    new Thread() {
      public void run() {
        Iterator<Entry<String, Object>> entryIterator = ConcurrentMapIterationCache.stringObjectConcurrentHashMap
            .entrySet().iterator();
        while (entryIterator.hasNext()) {
          Entry<String, Object> stringObjectEntry = entryIterator.next();
          if (stringObjectEntry.getKey().equals("a") || stringObjectEntry.getKey().equals("b")) {
            entryIterator.remove();
          }
        }
      }
    }.start();

    new Thread() {
      public void run() {
        Iterator<Entry<String, Object>> entryIterator = ConcurrentMapIterationCache.stringObjectConcurrentHashMap
            .entrySet().iterator();
        while (entryIterator.hasNext()) {
          Entry<String, Object> stringObjectEntry = entryIterator.next();
          System.out.print(stringObjectEntry.getKey() + ", ");
        }
      }
    }.start();

  }
}