package com.oc.associate.objectives;

public class MathRound {

    public static int roundDouble(String stringParameter){
        String str = stringParameter.substring(1, stringParameter.length()-1);
        double dbl = Double.parseDouble(str);
        return (int) Math.round(dbl);
    }

    public static void main(String args []){
        System.out.println(roundDouble("--0.6"));
    }
}
