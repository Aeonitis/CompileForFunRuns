package com.oc.programmer.objectives.collectionsgeneric;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueGeneric {

  /*
    Both LinkedList and PriorityQueue classes implement Queue interface.
   */
  Queue<Request> requestQueue = new LinkedList<>();       // Valid
  Queue<Request> priorityQueue = new PriorityQueue<>();   // Valid

  /**
   * These lines below are fine, but the type expected later is where they will fail depending on
   * the instances logic expected later on i.e. poll() function
   */
//  Queue priorityQueue = new LinkedList();               // Invalid - Type not set, will expect Object.poll() later
//  Queue priorityQueue = new PriorityQueue();            // Invalid - Type not set, will expect Object.poll() later

  /**
   * Invalid - Queue is an interface, cannot be instantiated. PriorityQueue is a class that implements Queue.
   */
//  Queue<Request> container = new Queue<Request>();

  public synchronized void addRequest(Request request) {
    requestQueue.add(request);
    priorityQueue.add(request);
  }

  /**
   * Since the return type of getRequestFromLinkedList() method is Request, and the return statement
   * does not have a cast, it means that container must be a typed generic collection that returns
   * Request objects only.
   */
  public synchronized Request getRequestFromLinkedList() {
    return requestQueue.poll();
  }

  /*
   * The use of poll() method indicates that it must be a Queue.
   */
  public synchronized Request getRequestFromPriorityQueue() {
    return priorityQueue.poll();
  }
}

class Request {

}