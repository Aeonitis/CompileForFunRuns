package com.oc.programmer.objectives.classdesign;

public class InterfacesStatic {

  public static void main(String[] args) {

    Office myOffice = new HomeOffice();

    /**
     * Invalid, since the declared type of variable myOffice is Office, compiler will check the call to getAddress against Office interface.
     */
//    System.out.println(myOffice.getAddress());

    /**
     * However, getAddress in Office is static and Java 8 requires static interface method to be invoked using the interface name instead of a reference variable.
     */
    System.out.println(Office.getAddress());
  }
}


interface House {

  public default String getAddress() {
    return "Address: 101 House Str.";
  }
}

interface Office {

  public static String getAddress() {
    return "Address: 101 Office Str.";
  }
}

interface WFH extends House, Office {

}

class HomeOffice implements House, Office {

  public String getAddress() {
    return "Address: 101 HomeOffice Str.";
  }
}
