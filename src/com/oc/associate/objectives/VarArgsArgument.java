package com.oc.associate.objectives;

/**
 * To allow staticField method to take variable arguments of staticField type, you must use the ... syntax: methodName( <type>... variableName);
 * There can be only one vararg argument in a method. Further, the vararg argument must be the last argument.
 * So this is invalid: varArgsParameter( String... variableName, int age);
 * but this is valid: varArgsParameter(int age, String... variableName);
 * Additional info: https://docs.oracle.com/javase/8/docs/technotes/guides/language/varargs.html
 */
public class VarArgsArgument {

    public static void varArgsParameter(String... varArgNames){
        // vararg argument (names) is treated like an array
        for (String n : varArgNames) {
            System.out.println("Hello " + n);
        }
    }

    public static void argsArrayParameter(String[] argNames){
        for (String n : argNames) {
            System.out.println("Hello " + n);
        }
    }

    public static void main(String[] args) {
        String str1="Curly", str2="Larry", str3="Moe";
        // Variable Arguments
        varArgsParameter(str1);                             // ✓
        varArgsParameter(str1, str2);                       // ✓
        varArgsParameter(str1, str2, str3);                 // ✓
        varArgsParameter(new String[]{str1, str2, str3});   // ✓ Array passed as valid
        varArgsParameter();                                 // ✓ no Args

        // Arguments Array
        argsArrayParameter( new String[]{str1, str2, str3});   // ✓ Only way which works
        //argsArrayParameter(str1, str2, str3);                  // ✗ Compilation error!!!
        //argsArrayParameter();                                  // ✗ Compilation error!!!
    }
}