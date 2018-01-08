package com.oc.associate.objectives;

public class FinalKeyword {
    public static void main(String[] args) {
        Human human = new Woman();
        human.feel();
    }
}

abstract class Human {
    public final void feel() {
        System.out.println("A human feels...");
    }
}

class Woman extends Human {
//    public void feel() {                      // Cannot override, method is Final.
//        System.out.println("A woman feels");
//    }

}
