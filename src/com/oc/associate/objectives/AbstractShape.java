package com.oc.associate.objectives;

/**
 * Abstract method in class requires that the class must be declared abstract.
 */
public abstract class AbstractShape {
    public abstract void draw();
}


class Circle extends AbstractShape {
    public void draw() {
        System.out.println("in draw...");
    }
}