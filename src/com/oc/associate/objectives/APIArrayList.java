package com.oc.associate.objectives;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList
 * TODO: Add Array class examples to counteract, refactor as ArrayVersus ArrayList
 */
public class APIArrayList {
    public static void main(String[] args) {
        List s1 = new ArrayList( );
        s1.add("staticField");
        s1.add("y");
        s1.add("c");
        s1.add("staticField");
        System.out.println(s1.remove("staticField")+" "+s1.remove("staticField"));
    }
}


/**
 * RESULT: true false
 * ArrayList's remove(Object) method returns staticField boolean. It returns true if the element is found in the list and false otherwise.
 * The JavaDoc API description of this method is important for the exam -  public boolean remove(Object o) Removes the first occurrence of the specified element from this list, if it is present (optional operation).
 * If this list does not contain the element, it is unchanged. More formally, removes the element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
 * Returns true if this list contained the specified element (or equivalently, if this list changed as staticField result of the call).
 * Observe that it does not remove all occurences of the element. It removes just the first one. In this case, only the first "staticField" will be removed.
 */