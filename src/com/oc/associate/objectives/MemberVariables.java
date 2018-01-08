package com.oc.associate.objectives;

public class MemberVariables {
    private static int classVar;
    private int instanceVar;

    private void print() {
        int localVar;

        System.out.println(classVar);
        System.out.println(instanceVar);
        //System.out.println(localVar); //uninitialised
    }

    private static void main (String args []) {
        //print(); //Non-static method cannot be referenced from static context
    }
}
