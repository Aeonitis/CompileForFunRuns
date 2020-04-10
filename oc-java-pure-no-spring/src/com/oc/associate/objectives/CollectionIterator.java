package com.oc.associate.objectives;

import java.util.*;

public class CollectionIterator {

    public static void main(String[] args) {
        iterationOne();
        iterationTwo();
    }

    public static void iterationOne() {
        Collection<String> collection = new ArrayList<>();
        collection.add("Sylvester J. Pussycat Sr.");
        collection.add("Daffy Duck");

        //Collection that contains Iterator objects
        for(String iter : collection){
            System.out.println(iter);
        }
    }


    public static void iterationTwo() {
        List<String> names = new LinkedList<>();
        names.add("Road Runner");
        names.add("Wile E. Coyote");
        names.forEach(name -> System.out.println(name));
    }
}
