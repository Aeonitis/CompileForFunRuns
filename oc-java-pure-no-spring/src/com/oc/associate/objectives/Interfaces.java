package com.oc.associate.objectives;

/**
 * Notes:
 * - Interfaces cannot be final.
 * - Interfaces are always abstract.
 * - Interfaces can have static methods.
 */
public class Interfaces {
}

interface InterfaceA {
    int getI(int a, int b);
}

interface InterfaceB {
    int getJ(int a, int b, int c);
}

abstract class AbstractClassOne implements InterfaceB, InterfaceA { }

class NoAccessModifierClassA implements InterfaceB, InterfaceA {
    @Override
    public int getI(int a, int b) {
        return 0;
    }

    @Override
    public int getJ(int a, int b, int c) {
        return 0;
    }
}

class NoAccessModifierClassB {
    int getI(int x, int y){ return x+y; }
}

interface K extends InterfaceB {
    int getJ(int a, int b, int c, int d);
}
