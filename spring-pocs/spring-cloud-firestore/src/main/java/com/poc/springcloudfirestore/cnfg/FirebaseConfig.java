package com.poc.springcloudfirestore.cnfg;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.poc.springcloudfirestore.xcpn.NotImplementedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    private final String collectionUsersName = "users";

    private final String collectionGamersName = "gamers";

    @Value("${google.cloud.projectId}")
    private String projectId;

    @Bean
    public Firestore localFirestoreConfig(@Value("${google.cloud.credentials}") String credentialsPath,
                                          @Value("${app.deploy.environment}") String currentEnvironment) throws IOException {

        switch (currentEnvironment) {
            case "local":
                return initializeDataStoreOnServer(credentialsPath);

            case "gcp":
                return initializeDatastoreOnGCPCredentials();

            case "default":
                return FirestoreOptions.getDefaultInstance().toBuilder().build().getService();

            case "defaultNamedProjectID":
                return firestoreFromNamedProjectID();

            default:
                System.out.println("Are you crazy, where are my properties!");
                throw new NotImplementedException();
        }
    }

    @Bean
//    @Qualifier("userCollection")
    public CollectionReference userCollection(Firestore firestore) {
        return firestore.collection(collectionUsersName);
    }

//        public CollectionReference collectionGamersReference(Firestore firestore) {
//        return firestore.collection(collectionGamersName);
//    }

    public Firestore firestoreFromNamedProjectID() {
        return FirestoreOptions.getDefaultInstance().toBuilder().setProjectId(projectId).build().getService();
    }

    /**
     * Initialize Firestore on Google Cloud Platform
     * Fetches the Google Application Default Credentials which are used to identify and authorize the
     * * whole application
     * <p>
     * Alternative: Initialize Firestore on your own server
     *
     * @throws IOException
     */
    public Firestore initializeDatastoreOnGCPCredentials() throws IOException {
        // Use the application default credentials
        GoogleCredentials googleCredentials = GoogleCredentials.getApplicationDefault();
        FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                .setCredentials(googleCredentials)
                .setProjectId(projectId)
                .build();
        FirebaseApp.initializeApp(firebaseOptions);

        return FirestoreClient.getFirestore();
    }


    /**
     * Initialize Firestore on your own server
     * Note: Needs your service account. Go to IAM & admin > Service accounts in the Cloud Platform Console.
     * Generate a new private key and save the JSON file. Then use the file to initialize the SDK
     * <p>
     * Alternative: Initialize Firestore on Google Cloud Platform
     *
     * @throws IOException
     */
    public Firestore initializeDataStoreOnServer(String localCredentialsPath) throws IOException {
        InputStream serviceAccount = new FileInputStream(localCredentialsPath);
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build();
        FirebaseApp.initializeApp(options);

        return FirestoreClient.getFirestore();
    }
}
