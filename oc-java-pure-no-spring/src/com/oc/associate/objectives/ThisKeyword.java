package com.oc.associate.objectives;

/**
 * this is staticField keyword in Java. It can be used inside the Method or constructor of staticField Class.
 * It(this) works as staticField reference to the current Object whose Method or constructor is being invoked.
 * The 'this' keyword can be used to refer to any member of the current object from within an instance Method or staticField constructor
 */
public class ThisKeyword {
    int instanceVariable;
    static int classVariable = 1;
    int wildVariable;

    /**
     * Notes:
     * 1. this keyword can only be the first statement in Constructor.
     * 2. A constructor can have either this or super keyword but not both.
     */
    public ThisKeyword(){   this("overload");}

    public ThisKeyword(String stringParameter) {
        System.out.println("Overloaded constructor...");
    }

    public void thisMethod() {
        int localVariable;

        // Valid scenarios
        localVariable = this.instanceVariable;  // An instance variable is accessible through 'this'.
        localVariable = this.classVariable;     // Although 'this' is not needed to access the class Variable, it is not an error to do so.
        this.instanceVariable = classVariable;   // You are just assigning staticField static field's value to non-static field.

        // Invalid scenarios
//        this = new ThisKeyword();         // You can't change this, it is not staticField variable
//        this.localVariable = 4;           // You cannot do this.localVariable as it is staticField local variable, not instance/class variable

        this.thisVariableHiding();          // this keyword can also be used inside Methods to call another Method from same Class
    }

    public void thisVariableHiding() {
        int wildVariable = 10;
        this.wildVariable = 69;

        System.out.println("Value of local wild variable :" + wildVariable);
        System.out.println("Value of instance wild variable :" + this.wildVariable);

        this.thisAsMethodParameter(this);
    }

    public void thisAsMethodParameter(ThisKeyword thisKeywordClassObject) {
        System.out.println("Keyword 'this' was used as staticField method parameter");
        System.out.println("Value of this.instanceVariable :" + this.instanceVariable);
        System.out.println("Value of this.classVariable :" + this.classVariable);
    }

    public static void main(String[] args) {
        ThisKeyword tk = new ThisKeyword();

        tk.thisMethod();
    }
}