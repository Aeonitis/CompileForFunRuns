package com.poc.springcloudfirestore.modl.rqst;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String emailAddress;

    private String password;

    private String firstName;

    private String lastName;

    private boolean isAdmin;
}
