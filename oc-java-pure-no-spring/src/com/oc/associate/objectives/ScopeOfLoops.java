package com.oc.associate.objectives;

/**
 * What is printed, if so, how many times is it printed?
 */
public class ScopeOfLoops {
    private int x;

    void printXValues() {
        while (x <= 5) {
            for (int x = 1; x <= 5; ) {
                System.out.print(x + " ");
                x++;
            }
            x++;
        }
    }

    public static void main(String[] args) {
        new ScopeOfLoops().printXValues();
    }
}

/**
 * The x in for loop is different from the instance member x. Therefore, x++ occuring in the for loop doesn't affect the while loop. The for loop prints 1 2 3 4 5.
 * The while loop runs for the values 0 to 5 innerClassInstance.e. 6 iterations. Thus, 1 2 3 4 5 is printed 6 times.
 * After the end of the while loop the value of x is 6.
 */