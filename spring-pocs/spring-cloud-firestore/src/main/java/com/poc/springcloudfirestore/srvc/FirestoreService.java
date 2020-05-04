//package com.poc.springcloudfirestore.srvc;
//
//import com.google.api.core.ApiFuture;
//import com.google.cloud.firestore.*;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.ExecutionException;
//
//@Service
//public class FirestoreService {
//
//    private final Firestore firestore;
//    private final CollectionReference collectionReference;
//
//
//    public FirestoreService(Firestore firestore, CollectionReference collectionReference) {
//        this.firestore = firestore;
//        this.collectionReference = collectionReference;
//
////        this.firestore = new FirebaseConfig().firestore();
//    }
//
//    //    private final Firestore firestore;
////
////    public FirestoreService(Firestore firestore) {
////        this.firestore = firestore;
//////        firebaseConfig.firestore();
////    }
//
//
//    public void addDocument() throws ExecutionException, InterruptedException {
//        DocumentReference docRef = collectionReference.document("myDocument");
//        // Add document docMap  with id "youdidit" using a hashmap
//        Map<String, Object> docMap = new HashMap<>();
//        docMap.put("name", "Beaned");
//        docMap.put("location", new GeoPoint(10, -30));
//        //asynchronously write docMap
//        ApiFuture<WriteResult> result = docRef.set(docMap);
//
//        // result.get() blocks on response
//        System.out.println("Update time : " + result.get().getUpdateTime());
//
//    }
//}
