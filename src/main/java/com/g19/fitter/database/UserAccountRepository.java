package com.g19.fitter.database;

/*
 * Created by davidsudia on 4/27/16.
 */

import org.springframework.data.mongodb.repository.MongoRepository;

interface UserAccountRepository extends MongoRepository<UserAccount, String> {

    UserAccount findByUsername(final String username);

}