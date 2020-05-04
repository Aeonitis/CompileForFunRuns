package com.poc.springcloudfirestore.modl.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDao implements Serializable {
    private String userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
}
