package com.oc.associate.objectives;

public class LoopsAndConstructs {

    public static void main(String args[]) {
//        runTestOne();
//        runTestTwo();
//        runTestThree();
//        runTestFour();
        runTestFive();
    }

    /*
        What will the following code print?
     */
    public static void runTestOne() {
        for (; ; ) {
//            Math.random()<.05?break:continue;
        }
    }

    /*

     */
    public static void runTestTwo() {
        int i = 1;
        switch (i) {
            default:
                System.out.println("YO");
            case 1:
                System.out.println("NO");
        }


    }

    /**
     * The use of break keyword is not mandatory, and without it the control will simply fall through the labels of the switch statement.
     */
    public static void runTestThree() {
        byte by = 10;
        switch (by) {
            case 'a':
//            case 256:   // Will not compile as 256 cannot fit into x byte.
            case 0:
            default:
                by = 56;
            case 80:
//            case 301 :  // Will not compile as 301 is not assignable to 'by ' which can only hold values from -128 to 127.
            case 56:   //some code;
        }
        System.out.println(by);
        System.out.println(Integer.toBinaryString((int) by));
    }


    /**
     * The statement:  if(innerClassInstance < j) continue OUTERLOOP; else break INNERLOOP; only makes sure that the inner loop does not iterate more than once.
     * innerClassInstance.e. for each iteration of innerClassInstance, j only takes the value of 4 and then the j loop terminates, either because of continue OUTERLOOP; or because of break INNERLOOP;.
     * When the loop for(innerClassInstance = 0; innerClassInstance < 4; innerClassInstance++) ends, the value of innerClassInstance is 4 and not 3. Similarly, if there were no statement inside inner loop, the value of j after the end of the loop would have been 0 and not 1.
     */
    public static void runTestFour() {
        int i = 0, j = 0;
        OUTERLOOP:
        for (i = 0; i < 4; i++) {
            System.out.println("In OUTERLOOP:");
            INNERLOOP:
            for (j = 4; j > 0; j--) {
                System.out.println("\tIn INNERLOOP: innerClassInstance=" + i + ",j=" + j);
                if (i < j) {
                    System.out.println("\t\tcontinue outer ⤣");
                    continue OUTERLOOP;
                } else {
                    System.out.println("\t\tbreak inner ⇏");
                    break INNERLOOP;
                }
            }
        }
        System.out.println(i + " " + j);
    }

    /*

     */
    public static void runTestFive() {
        processArray(new int[] {1,2,3,40,50});

    }

    public static void processArray(int[] values) {
        int sum = 0;
        int i = 0;
        try {
            while (values[i] < 5) {
                sum = sum + values[i];
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        System.out.println("sum = " + sum);
    }


}


