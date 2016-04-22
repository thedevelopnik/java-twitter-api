package com.g19.fitter.data;

import java.util.List;

import com.g19.fitter.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by davidsudia on 4/22/16.
 */
public interface UserRepository extends MongoRepository<User, String> {

    public User findByEmail(String email);

}
