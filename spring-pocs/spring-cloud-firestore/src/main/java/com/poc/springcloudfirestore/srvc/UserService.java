package com.poc.springcloudfirestore.srvc;

import com.poc.springcloudfirestore.modl.User;
import com.poc.springcloudfirestore.modl.dao.UserDao;
import com.poc.springcloudfirestore.modl.rqst.CreateUserRequest;
import com.poc.springcloudfirestore.repo.UserFirestoreRepository;
import com.poc.springcloudfirestore.xcpn.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.poc.springcloudfirestore.hlpr.FirestoreHelper.generateFirestoreID;
import static com.poc.springcloudfirestore.hlpr.transformer.UserTransformer.transformToBaseEntity;
import static com.poc.springcloudfirestore.hlpr.transformer.UserTransformer.transformToDao;

@Service
public class UserService {

    @Autowired
    private UserFirestoreRepository userFirestoreRepository;

    public User createUser(CreateUserRequest createUserRequest) {

        if (userFirestoreRepository.existsByEmailAddress(createUserRequest.getEmailAddress()))
            throw new ConflictException("Document [" + createUserRequest.getEmailAddress() + "] already exists");

        final User newUserFromRequest = buildNewUserFromRequest(createUserRequest);

        UserDao userDao = transformToDao(newUserFromRequest);
        userFirestoreRepository.insertUser(userDao);

        return newUserFromRequest;
    }

    private User buildNewUserFromRequest(CreateUserRequest createUserRequest) {
        User newUser = transformToBaseEntity(createUserRequest);
        newUser.setUserId(generateFirestoreID());
        return newUser;
    }
}
