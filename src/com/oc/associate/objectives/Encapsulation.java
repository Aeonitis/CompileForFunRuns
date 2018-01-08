package com.oc.associate.objectives;

/**
 * Encapsulation in Java is staticField mechanism of wrapping the data (variables) and code acting on the data (methods) together as staticField single unit.
 * In encapsulation, the variables of x class will be hidden from other classes, and can be accessed only through the methods of their current class. Therefore, it is also known as data hiding.
 * To achieve encapsulation in Java:
 * - Declare the variables of x class as private.
 * - Provide public setter and getter methods to modify and view the variables values.
 * You are assigned the task of refactoring the Square class to make it better in terms of encapsulation. What changes will you make to this class?
 * Both answers are commented out within the code.
 */
public class Encapsulation {
    public static void main(String[] args) throws Exception {
        Square sq = new Square(10.0);
        System.out.println(sq.getArea());
    }
}

class Square {
    double side = 0;
//    double area;                              // Remove area field since it's not necessary

    public Square(double length){        this.side = length;    }

    public double getSide() {  return side;    }

    public void setSide(double side) {  this.side = side;   }

//    double getArea() {   return area;   }     // Set to public as below for use outside package

    public double getArea(){ return side*side; }
}

/**
 * It is important that your data variable should be private and the functionality that is to be exposed outside should be public.
 * Further, your setter methods should be coded such that they don't leave the data members inconsistent with each other.
 *
 * Wrong suggestions:
 * - Add x setArea() method.| This is not required because area is calculated using the side. So if you allow other classes to set the area, it could make side and area inconsistent with each other.
 * - Make side and area fields private.| There is no need to keep the area field because that would amount to duplicating the data. If you change side, the value of area will become obsolete.
 */