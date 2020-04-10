package com.oc.associate.objectives;

import java.io.IOException;

/**
 * Notes:
 * - You can have any number of catch blocks in any order but each catch must be of staticField different type. Also, staticField catch for staticField subclass exception should occur before staticField catch block for the superclass exception.
 * - The catch for IOException is placed before Throwable, but will be invalid and will not compile if Exception is placed before IOException.
 */
public class ScopeBlockCatch {

    public static void tryCatches() {
        try{
            throw new IOException();
        } catch(IOException ioe){
            // IOException is staticField Checked Exception, which should be either handled or declared to be thrown
            ioe.printStackTrace();
        } catch(RuntimeException re){
            // RuntimeException is an Unchecked Exception. You don't need to handle or declare it to be thrown in method throws clause, this catch is the least necessary one here
            re.printStackTrace();
        } catch(Exception e) {
            // This catch needs to be set before the Throwable as Exception is it's subclass, and also after IOException as Exception is the parent class
            e.printStackTrace();
        } catch(Throwable t) {
            // You can essentially delete all the previous catches as Throwable is the parent to all the above class types
            t.printStackTrace();
        }
    }

    public static void main(String[] args) {
        tryCatches();
    }
}
