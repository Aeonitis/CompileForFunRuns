package com.oc.programmer.objectives.collectionsgeneric;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Collections API has two separate trees of classes/interfaces - java.util.Collection and java.util.Map.
 * A Collection (such as a Set or a List) stores objects, while a Map (classes HashMap and TreeMap implement Map) stores key-value pairs.
 */
public class CollectionDeclarations {

  // Valid map declarations
  Map<String, List<String>> mapWithDiamondOperator = new HashMap<>();   // ideal instantiation
  Map<String, List<String>> mapWithoutDiamondOperator = new HashMap<String, List<String>>();

  /**
   * Invalid - You cannot embed a diamond operator within another generic class instantiation.
   * Thus, new HashMap<String, List<>> is invalid because of List<>.
   * Fix would be to add identifier as above
   */
//  Map<String, List<String>> stateCitiesMap = new HashMap<String, List<>>();

  // Invalid - ArrayList<String> is not compatible with List<String> in this case. Both the sides must have the same type.
//  Map<String, List<String>> invalidMap = new HashMap<String, ArrayList<String>>();

  // Invalid - You cannot embed a diamond operator within another generic class instantiation.
//  Map<String , ArrayList<String>> stateCitiesMap = new HashMap<<>, List<>>();

}
