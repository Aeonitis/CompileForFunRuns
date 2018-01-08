package com.oc.associate.objectives;

public class ConversionsImplicit {
    long validOctalNumber = 012;
    short s = 12;                       // Implicit narrowing conversion: valid since 12 can fit into a short
    float f = -123;                     // Implicit widening conversion

//    float d = 0*1.5;                  // Can't implicitly narrow double to float even though the value is representable by a float
}
