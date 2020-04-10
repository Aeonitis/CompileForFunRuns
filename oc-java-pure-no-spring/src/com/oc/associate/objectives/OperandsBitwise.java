package com.oc.associate.objectives;

/**
 & (bitwise and)	    Binary AND Operator copies a bit to the result if it exists in both operands.	(A & B) will give 12 which is 0000 1100
 | (bitwise or)	        Binary OR Operator copies a bit if it exists in either operand.	                (A | B) will give 61 which is 0011 1101
 ^ (bitwise XOR)	    Binary XOR Operator copies the bit if it is set in one operand but not both.	(A ^ B) will give 49 which is 0011 0001
 ~ (bitwise compliment)	Binary Ones Complement Operator is unary and has the effect of 'flipping' bits.	 (~A ) will give -61 which is 1100 0011 in 2's complement form due to a signed binary number.
 << (left shift)	    Binary Left Shift Operator. The left operands value is moved left by the number of bits specified by the right operand.	A << 2 will give 240 which is 1111 0000
 >> (right shift)	    Binary Right Shift Operator. The left operands value is moved right by the number of bits specified by the right operand.	A >> 2 will give 15 which is 1111
 >>> (zero fill right shift)	Shift right zero fill operator. The left operands value is moved right by the number of bits specified by the right operand and shifted values are filled up with zeros.	A >>>2 will give 15 which is 0000 1111
 */
public class OperandsBitwise {

    static byte a =0b00111100;
    static byte b =0b00001101;

    public static void main(String[] args) {
        System.out.println("  a:   "+ Integer.toBinaryString(a));
        System.out.println("  b:   "+ Integer.toBinaryString(b));
        System.out.println("a&b:   "+ Integer.toBinaryString(a&b));
        System.out.println("a|b:   "+ Integer.toBinaryString(a|b));
        System.out.println("a^b:   "+ Integer.toBinaryString(a^b));
        System.out.println(" ~a:   "+ Integer.toBinaryString(~a));
        System.out.println(" ~b:   "+ Integer.toBinaryString(~b));
    }

}

/**
 * Results:
 a:     111100
 b:       1101
 a&b:     1100
 a|b:   111101
 a^b:   110001
 ~a:    11111111111111111111111111000011
 ~b:    11111111111111111111111111110010
 */
