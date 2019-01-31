package com.oc.associate.objectives;

public class PrimitiveDataTypes {

    // Valid hex/binary/decimal declarations
    double hexedDouble = 0xB1_0000;         // 0x implies interpretation as Hexadecimal digits and 'B' is a valid Hexadecimal digit innerClassInstance.e. 0 to F.
    float hexedFloat = 0xff;                // is valid but the f here is not for indicating that it is a float but is interpreted as the hex digit F.
    long hexedLong = 0x1000_0L;             // L suffix for Long is valid, 5 out of 64 binary bits used to fill this long
    byte binaryByte = 0b01111111;           // 0b implies interpretation as binary, limited to 8 bits, signed two's complement integer
    short binaryShort = 0B0111111111111111; // 0B implies interpretation as binary, limited 16-bit signed two's complement integer
    int binaryInteger = 0b011111111111111111111111111111111;    // An unsigned 32-bit integer, which has a minimum value of 0 and a maximum value of 232-1
    float binaryFloat = 0B10_000;           // Floating-point literal suffix f/F is not valid with binary/hex values. Binary value, an explicit cast is not required since 10,000 can fit into a float innerClassInstance.e. 5 out of 32 bits, otherwise it won't compile.
    long binaryLong = 0b1000_0L;            // L suffix for Long is valid, 5 out of 64 binary bits used to fill this long
    double decimalDouble = 100_00D;         // A floating point number written in binary or hex cannot use any floating point suffices f/F/d/D.

    short myShort = 10;
    char myChar = (char)myShort;            // Not all short values are valid char values, unless explicitly cast
    char newShort = (short)'A';             // Neither are all char values valid short values e.g. a short is capable of holding negative values while char isn't
    double floatCastTwiceToDouble = (double)(int)1.1f;  //Reference here cannot be an int, You cannot assign a double to an int without casting it to int
    int doubleCastToInt = (int)floatCastTwiceToDouble;

    public static void main(String[] args) {
        System.out.println("Byte: " + (int) Byte.MIN_VALUE + "|" + (int)Byte.MAX_VALUE);
        System.out.println("Short: " + (int) Short.MIN_VALUE + "|" + (int)Short.MAX_VALUE);
        System.out.println("Integer: " + Integer.MIN_VALUE + "|" + Integer.MAX_VALUE);
        System.out.println("Float: " + Float.MIN_VALUE + "|" + Float.MAX_VALUE);
        System.out.println("Long: " + Long.MIN_VALUE + "|" + Long.MAX_VALUE);
        System.out.println("Double: " + Double.MIN_VALUE + "|" + Double.MAX_VALUE);
        System.out.println("Char: " + (int) Character.MIN_VALUE + "|" + (int)Character.MAX_VALUE);
    }
}
