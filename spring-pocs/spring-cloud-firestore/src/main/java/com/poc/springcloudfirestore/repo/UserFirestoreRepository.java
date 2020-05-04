package com.poc.springcloudfirestore.repo;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.poc.springcloudfirestore.modl.dao.UserDao;
import com.poc.springcloudfirestore.repo.i.UserRepository;
import com.poc.springcloudfirestore.xcpn.InternalServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.poc.springcloudfirestore.hlpr.FirestoreHelper.generateFirestoreID;
import static com.poc.springcloudfirestore.modl.cnst.UserConstants.FIELD_EMAIL_ADDRESS;

@Repository
public class UserFirestoreRepository implements UserRepository {

    @Autowired
    private Firestore firestore;

    @Autowired
    private CollectionReference collectionUsersReference;

    @Override
    public void insertUser(UserDao userDao) {
        try {
            ApiFuture<WriteResult> writeResultApiFuture = collectionUsersReference.document(userDao.getUserId()).set(userDao);
            System.out.println("Write time: " + writeResultApiFuture.get().getUpdateTime());
        } catch (Exception e) {
            throw new InternalServerException();
        }
    }

    @Override
    public boolean existsByEmailAddress(String emailAddress) {
        try {
            Query query = collectionUsersReference.whereEqualTo(FIELD_EMAIL_ADDRESS, emailAddress);
            ApiFuture<QuerySnapshot> querySnapshotApiFuture = query.get();
            List<QueryDocumentSnapshot> queryDocumentSnapshots = querySnapshotApiFuture.get().getDocuments();

            return !queryDocumentSnapshots.isEmpty();
        } catch (Exception e) {
            throw new InternalServerException();
        }
    }

    @Override
    public void updateUser(UserDao userDao) {
        try {
            DocumentReference documentReference = collectionUsersReference.document(generateFirestoreID());
            ApiFuture<WriteResult> writeResultApiFuture = documentReference.set(userDao);
            writeResultApiFuture.get();
        } catch (Exception e) {
            throw new InternalServerException();
        }
    }

}
