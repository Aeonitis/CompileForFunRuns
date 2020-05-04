package com.poc.springcloudfirestore.hlpr;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class FirestoreHelper {

    public static String generateFirestoreID() {
        return String.valueOf(UUID.randomUUID());
    }
}
