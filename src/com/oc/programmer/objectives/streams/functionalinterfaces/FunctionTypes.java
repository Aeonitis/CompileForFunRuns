package com.oc.programmer.objectives.streams.functionalinterfaces;

/**
 * java.util.function package contains int, double, and long (but no float) versions of all the functional interfaces.
 * There is an IntFunction, a DoubleFunction, and a LongFunction, which are int, double, and long, versions of Function.
 */
import java.util.function.IntFunction;

/**
 * Primitive and object versions of data types (innerClassInstance.e. int and Integer, double and Double, etc.) are
 * made compatible through the extra step of auto-boxing/unboxing.   Thus, if you have a stream of
 * primitive ints and if you try to use the object versions of Stream and Function (innerClassInstance.e.
 * Stream<Integer> and Function<Integer, Integer>, you will incur the cost of boxing and unboxing
 * the elements.
 *
 * To eliminate this problem, the function package contains primitive specialized versions of
 * streams as well as functional interfaces. For example, instead of using Stream<Integer>, you
 * should use IntStream. You can now process each element of the stream using IntFunction. This will
 * avoid auto-boxing/unboxing altogether. Thus, whenever you want to process streams of primitive
 * elements, you should use the primitive specialized streams (innerClassInstance.e. IntStream, LongStream, and
 * DoubleStream) and primitive specialized functional interfaces (innerClassInstance.e. IntFunction, IntConsumer,
 * IntSupplier etc.) to achieve better performance.
 */
public class FunctionTypes {

  // IntFunction takes int primitive as an argument. It can be parameterized to return any thing e.g. String
  IntFunction<String> intFunctionWhichReturnsString = x -> "" + x;

  /**
   * None of the primitive specialized functional interfaces (such as IntFunction, DoubleFunction, or IntConsumer)
   * extend the non-primitive functional interfaces (innerClassInstance.e. Function, Consumer, and so on).
   */

}
