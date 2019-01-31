package com.oc.associate.objectives;

public class Bytes {

    public static void byting() {
        byte byteOne = 30;
        byte byteTwo = 127;   // 127 is max, -128 min innerClassInstance.e. can only hold values from -128 to 127.
        byte byteThree = (byte) 128; // Need to cast to byte, or else won't compile (incompatible types) 128 prints as -128
        byte byteFour = (byte)256;  // Will not compile as 256 cannot fit into a byte. Why 256=Zero?

        printAsIntAndBin(byteOne);
        printAsIntAndBin(byteTwo);
        printAsIntAndBin(byteThree);
        printAsIntAndBin(byteFour);
    }

    public static void printAsIntAndBin(byte byteToPrint){
        System.out.println("INT: "+ byteToPrint);
        System.out.println("BIN: "+ Integer.toBinaryString((int)byteToPrint));
    }

    public static void main(String args[]) {
        byting();
    }
}