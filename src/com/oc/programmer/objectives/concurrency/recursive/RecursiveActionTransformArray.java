package com.oc.programmer.objectives.concurrency.recursive;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Use case: To update each element of the array and update that element.
 * The new value of the element is generated by a utility class's static method,
 * which takes in the existing value as a parameter and returns the new value.
 *
 * This method is computationally very intensive.
 */
public class RecursiveActionTransformArray extends RecursiveAction {
  int[] intArray;
  int from;
  int to;

  public static void main(String[] args) {
    int intArray[] = new int[]{1, 2, 3, 4};
//    int intArray[] = new int[]{1, 2, 3, 4, 5, 6, 7};
    ForkJoinPool forkJoinPool = new ForkJoinPool();

    RecursiveActionTransformArray recursiveActionTransformArray = new RecursiveActionTransformArray(intArray, 0, 3);
//    RecursiveActionTransformArray recursiveActionTransformArray = new RecursiveActionTransformArray(intArray, 0, 7);
    forkJoinPool.invoke(recursiveActionTransformArray);
    System.out.print("New Array Values = " + Arrays.toString(intArray));
  }

  /**
   * Since there is no requirement to do anything with the newly computed value (such as summing them up),
   * we don't need to return that value to anybody. We just need to update the array element with the new value.
   * Therefore, we don't need RecursiveTask, you need RecursiveAction.
   */
  public RecursiveActionTransformArray(int[] intArray, int from, int to) {
    this.intArray = intArray;
    this.from = from;
    this.to = to;
  }

  protected void compute() {
    if(from == to) {

    //Update the value using logic implemented somewhere else.
    intArray[from] = UtilityClass.incrementsByOne(intArray[from]);

      System.out.println("Array = " + Arrays.toString(intArray));
    } else {

      int mid = (from + to) / 2;
      // RecursiveAction that subdivides the task into two, then forks one of the tasks and computes another.
      RecursiveActionTransformArray taskFirstHalf = new RecursiveActionTransformArray(intArray, from, mid);
      RecursiveActionTransformArray taskSecondHalf = new RecursiveActionTransformArray(intArray, mid + 1, to);

      System.out.println("ForkedCompute "
          + "| FirstTask: " + taskFirstHalf.toString()
          + " | SecondTask: " + taskSecondHalf.toString()
          + " | " + Thread.currentThread().getName());

      taskSecondHalf.fork();

      System.out.println("computing...");
      taskFirstHalf.compute();

      System.out.println("joining...");
      taskSecondHalf.join();
    }
  }



  @Override
  public String toString() {
    return "from=" + from +
        ", to=" + to +
        '}';
  }
}

class UtilityClass {

  public static int incrementsByOne(int intToIncrement) {

    int incrementedInt = intToIncrement + 1;
    System.out.println("inc " + intToIncrement + " to " + incrementedInt);
    return incrementedInt; }
}