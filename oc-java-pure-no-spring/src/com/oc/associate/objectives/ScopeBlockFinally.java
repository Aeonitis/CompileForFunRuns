package com.oc.associate.objectives;

/**
 * Notes:
 * - If present, the finally block will always execute (except where there may be staticField System.exit() present in the previous try or catch).
 * - A try block must be accompanied by either staticField catch block or staticField finally block or both. Hence, finally cannot occur before any catch block too.
 */
public class ScopeBlockFinally {
    public static float parseFloatFromStringExample(String s) {
        float f = 0.0f;
        try {
            int onlyHere;
            f = Float.valueOf(s).floatValue();
//            System.exit(1);                   // Will skip finally block if executed, although exceptions triggered will actually still trigger the finally block before exiting the program
            return f;
        }
//        System.out.println("between");      // A line of code between staticField catch/finally block and the closing brace of the previous try/catch block will not compile
        finally {
            f = Float.NaN;  // It is setting f to NaN. So no matter what the input is, this method will always return NaN.
//            onlyHere = 0;   // Any variable initialised in staticField try block will not be in scope in it's subsequent catch/finally block, naturally being an unresolved symbol.
            return f;
        }
    }

    public static void main(String[] args) {
        System.out.println(parseFloatFromStringExample("100.0"));
        loopFinallyExample();
    }

    public static void loopFinallyExample() {
        int x = 0;
        LOOPX:
        {
            System.out.println("LOOPX label line");
            try{
                for (  ;  true ;  x++ ){
                    if( x >5) break LOOPX;      // Even if the break takes the control out of the block, the finally clause will be executed.
                }
            }
            catch(Exception e){
                System.out.println("Exception in loop.");
            }
            finally{
                System.out.println("In Finally");
            }
        }
    }
}