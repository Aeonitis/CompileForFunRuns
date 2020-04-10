package com.oc.associate.objectives;

public class PolyStaticVersusDynamicBinding {

    public static void main(String[] args) {
        // Reference is of Human type and object is Boy type
        StaticHuman staticHuman1 = new StaticBoy();
        DynamicHuman dynamicHuman1 = new DynamicBoy();

        // Reference is of Human type and object is of Human type
        StaticHuman staticHuman2 = new StaticHuman();
        staticHuman1.walk();
        staticHuman2.walk();

        DynamicHuman dynamicHuman2 = new DynamicHuman();
        dynamicHuman1.walk();
        dynamicHuman2.walk();
    }
}


/**
 * Static Binding (Compile time)
 * Both the classes (Human and Boy) have same method walk() but the method is static,
 * which means it CANNOT BE OVERRIDEN so even though I have used the object of Boy class while creating object obj, the parent class method is called by it.
 * Because the reference is of Human type (parent class).
 * So whenever a binding of static, private and final methods happen,
 * type of the class is determined by the compiler at compile time and the binding happens then and there.
 */
class StaticHuman{
    //This method is not Overridden
    public static void walk()
    {
        System.out.println("StaticHuman walks");
    }
}
class StaticBoy extends StaticHuman{
    public static void walk(){
        System.out.println("StaticBoy walks");
    }
}


/**
 * Dynamic Binding or Late Binding (Runtime)
 * Overriding actually occurs here since these methods are not static, private and final.
 * In case of overriding the call to the overriden method is determined at runtime by the type of object thus late binding happens.
 */
class DynamicHuman {
    //Overridden Method
    public void walk()
    {
        System.out.println("DynamicHuman walks");
    }
}
class DynamicBoy extends DynamicHuman {
    //Overriding Method
    public void walk(){
        System.out.println("DynamicBoy walks");
    }
}