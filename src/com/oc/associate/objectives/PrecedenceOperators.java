package com.oc.associate.objectives;

/**
 * Sequence/Precedence of evaluation:
 * OPERATOR                 PRECEDENCE
 * postfix			        expr++ expr--
 * unary			        ++expr --expr +expr -expr ~ !
 * multiplicative		    * / %
 * additive		            + -
 * shift			        << >> >>>
 * relational		        < > <= >= instanceof
 * equality		            == !=
 * bitwise AND		        &
 * bitwise exclusive OR	    ^
 * bitwise inclusive OR	    |
 * logical AND		        &&
 * logical OR	            ||
 * ternary			        ? :
 * assignment		        = += -= *= /= %= &= ^= |= <<= >>= >>>=
 */
public class PrecedenceOperators {
    boolean aBoolean = false;
    int anInt = 10;
    int anIntToo = 11;

    public void operate() {
        if(aBoolean=anInt==--anIntToo) {        // The expression aBoolean=anInt!=--anIntToo will be evaluated as aBoolean = (anInt==--anIntToo) because == has higher precedence than =.
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void main(String[] args) {
        PrecedenceOperators po = new PrecedenceOperators();
        po.operate();
    }
}
