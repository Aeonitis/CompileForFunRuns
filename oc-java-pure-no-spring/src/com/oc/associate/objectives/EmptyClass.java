package com.oc.associate.objectives;

public class EmptyClass {
    public void testRefs(String str, StringBuilder strb){
        str = str + strb.toString();
        strb.append(str);
        str = null;
        strb = null;
    }
    public static void main(String[] args){
        String s = "aaa";
        StringBuilder sb = new StringBuilder("bbb");
        new EmptyClass().testRefs(s, sb);
        System.out.println("s="+s+" sb="+sb);
    }
}


