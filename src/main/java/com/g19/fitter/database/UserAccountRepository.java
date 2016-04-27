package com.g19.fitter.database;

/*
 * Created by davidsudia on 4/27/16.
 */

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

    UserAccount findByEmail(final String email);

    List<UserAccount> findByEmailAndPassword(final String email, final String password);
}
