package com.oc.programmer.objectives.classdesign;

/**
 * Even though innerVar is a private member of InnerClass, InnerPeace itself is a member of outer class ScopeClass and so it can access 'innerVar'.
 * For example, you can have the a method defined inside ScopeClass and call it from outside ScopeClass:
 */
public class ScopeClass {

  public InnerClass innerClassInstance = new InnerClass();

  private class InnerClass {
    private String innerVar = "found";
  }

  public void accessInnerVar() {
    System.out.println(innerClassInstance.innerVar);
    System.out.println(this.innerClassInstance.innerVar);
//    System.out.println(ScopeClass.innerClassInstance.innerVar); // valid only if innerClassInstance was static
  }

}

class OuterClass {
  public static void tryAccessVarFromOutside() {
    new ScopeClass().accessInnerVar();
  }

  public static void main(String[] args) {
    tryAccessVarFromOutside();
  }
}

