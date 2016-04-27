package com.g19.fitter.database;

/*
 * Created by davidsudia on 4/27/16.
 */

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "DEV")
public class DataInitializer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MongoOperations operations;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    protected DbService dbService;

    @PostConstruct
    public void init() {
        String demoPasswordEncoded = encoder.encode("demo");
        logger.debug("initializing data, demo password encoded: {}", demoPasswordEncoded);

        //clear all collections, but leave indexes intact
        dbService.cleanUp();

        //establish roles
        operations.insert(new Role("ROLE_USER"), "role");
        operations.insert(new Role("ROLE_ADMIN"), "role");

        UserAccount user = new UserAccount();
        user.setFirstname("Bob");
        user.setLastname("Doe");
        user.setPassword(demoPasswordEncoded);
        user.addRole(userService.getRole("ROLE_USER"));
        user.setUsername("bob");
        userService.create(user);
        //simulate account activation
        user.setEnabled(true);
        user.setStatus(UserAccountStatus.STATUS_APPROVED.name());
        userService.save(user);

    }
}