package com.oc.programmer.objectives.io;

/**
 * Multiple copies of an object may be added to a stream. The same object can be serialized multiple
 * times to a stream. Thus, you may have multiple copies of the same object in the stream and when
 * you read the stream back, you will get multiple objects.
 *
 * A class which does not implement Serializable may trigger a NotSerializableException
 *
 * With regards to subclass Serialized objects, only the class needs to implement Serializable
 * interface. Also remember that if a super class declares that it implements Serializable, all its
 * subclasses automatically become serializable. There is no need for a subclass to explicitly
 * declare that it implements Serializable in such a case.
 *
 * When de-serializing, The no-argument constructor of only the first non-serializable super class is
 * invoked, throwing InvalidClassException. This constructor may internally invoke any constructor of its super class.
 * Solution: A no-arg constructor should be declared in the super class.
 */
public class SerializableIO {

}
