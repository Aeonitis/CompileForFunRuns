package com.oc.programmer.objectives.collectionsgeneric;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Deque can act as a Queue as well as a Stack. Based on this fact, you can deduce the following:
 *
 * 1. Since Queue is a FIFO structure (First In First Out i.e. add to the end and remove from the
 * front), it has methods offer(e)/add(e)(for adding an element to the end or tail) and
 * poll()/remove()(for removing an element from the front or head) for this purpose.  Note that
 * offer and add are similar while poll and remove are similar.
 *
 * 2. Since Stack is a LIFO structure (Last In First Out i.e. add to the front and remove from the front),
 * it provides methods push(e) and pop() for this purpose, where push adds to the front and pop removes from the front.
 */
public class DequeFunctions {

  static Deque<Integer> deque;

  public static void main(String[] args) {
    deque = new ArrayDeque<>();
    printMeAfterFunction("Empty");

    deque.add(1);                // add(e) is a queue method that adds the element to the end
    printMeAfterFunction("Added");
    deque.push(2);            // push() is a stack method that adds the element to the front
    printMeAfterFunction("Pushed");

    deque.pop();                 // pop() is a stack method that removes the element from the front
    printMeAfterFunction("Popped");

    deque.offerFirst(3);      // offerFirst(e), deque method that inserts the specified element at the front
    printMeAfterFunction("OfferFirst");
    deque.offerLast(4);       // offerFirst(e), deque method that Inserts the specified element at the end
    printMeAfterFunction("OfferLast");
    deque.offer(5);           // offer(e), queue method that adds the element to the end.
    printMeAfterFunction("Offer");

    System.out.println("peeking @" + deque.peek());   // peek(), queue method that (retrieves but DOES NOT remove) the head of this queue, returns null if empty

    deque.poll();                 // poll(), queue method that (retrieves AND removes) the head of this queue, returns null if empty
    printMeAfterFunction("poll");
    deque.remove();               // remove() is a queue method that removes the element from the front
    printMeAfterFunction("Remove");

  }

  public static void printMeAfterFunction(String functionName) {
    System.out.println(functionName + ": " + deque);
  }

}
