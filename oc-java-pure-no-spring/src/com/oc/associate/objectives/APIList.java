package com.oc.associate.objectives;

import java.util.ArrayList;
import java.util.List;

public class APIList {
    int saveCounter = 0;
    Object previousObject;

    public void saveObject(List l) {
        previousObject = l;
        saveCounter++;
    }

    public Object getPreviousObject() {
        return previousObject;
    }

    public static void main(String[] args) {
        APIList al = new APIList();

        al.saveObject(new ArrayList());

        List l = new ArrayList();
        al.saveObject(l);

        al.saveObject(null);
    }
}
