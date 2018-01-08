package com.oc.associate.objectives;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * When you write a lambda expression for a functional interface, you are essentially providing an implementation of the method declared in that interface but in a very concise manner.  
 * Therefore, the lambda expression code that you write must contain all the pieces of the regular method code except
 * the ones that the compiler can easily figure out on its own such as the parameter types, return keyword, and brackets.
 * So, in a lambda expression, just check that all the information is there and that the expression follows the basic syntax:
 * - (parameter list) OR single_variable_without_type -> { regular lines of code } OR just_an_expression_without_semicolon
 */
public class Lambdas {
    public static void main(String[] args) {
        ArrayList<Numero> arrayList = new ArrayList<>();

        arrayList.add(new Numero(0));
        arrayList.add(new Numero(1));
        arrayList.add(new Numero(2));
        arrayList.add(new Numero(3));
        arrayList.add(new Numero(4));
        arrayList.add(new Numero(5));

        /**
         * When all your method does is return the value of an expression, you can omit the
         * curly braces, the return keyword, and the semi-colon from the method body part.
         * Thus, instead of { return x.value%2 == 0; }, you can just write x.value%2 == 0
         */
        Numero.filterData(arrayList, (Numero x) -> x.value%2 == 0 );
//        Numero.filterData(arrayList, (Numero x) -> {return x.value%2 == 0;});     //Alternate way
        System.out.println(arrayList);
    }
}


class Numero {
    int value;

    Numero(int value) {
        this.value = value;
    }

    public String toString() {
        return "" + value;
    }

    // and the    following code fragments:
    public static void filterData(ArrayList<Numero> numeroList, Predicate<Numero> p) {
        Iterator<Numero> i = numeroList.iterator();
        while (i.hasNext()) {
            if (p.test(i.next())) {
                i.remove();
            }
        }
    }
}