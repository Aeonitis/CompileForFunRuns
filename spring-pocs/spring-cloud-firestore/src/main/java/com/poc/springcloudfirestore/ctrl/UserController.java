package com.poc.springcloudfirestore.ctrl;

import com.poc.springcloudfirestore.modl.User;
import com.poc.springcloudfirestore.modl.rqst.CreateUserRequest;
import com.poc.springcloudfirestore.srvc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }
}
