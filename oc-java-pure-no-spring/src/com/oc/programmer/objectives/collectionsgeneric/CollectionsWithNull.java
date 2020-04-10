package com.oc.programmer.objectives.collectionsgeneric;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsWithNull {

  public static void main(String[] args) {

    Map hashMap = new ConcurrentHashMap();
//    hashMap.put(null, "asdf"); // Inserting null key or null in a ConcurrentHashMap will throw a NullPointerException.
//    hashMap.put("aaa", null);  // TODO Why does ConcurrentHashMap.put() only work in static method only?

    // // HashMap supports adding null key as well as null values but ConcurrentHashMap does not.
    hashMap = new HashMap();
    hashMap.put(null, "asdf");
    hashMap.put("aaa", null);

    List list = new ArrayList();
    list.add(null);
    list.add(null);

    list = new CopyOnWriteArrayList();
    list.add(null);


  }

}
