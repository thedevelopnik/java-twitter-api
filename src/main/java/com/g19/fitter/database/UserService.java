package com.g19.fitter.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/*
 * Created by davidsudia on 4/27/16.
 */
@Service
public class UserService {

    @Autowired
    private UserAccountRepository userRepository;

    public boolean create(UserAccount user) {
        Assert.isNull(user.getId());

        if (userRepository.findByEmail(user.getEmail()) != null) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    public void save(UserAccount user) {
        Assert.notNull(user.getId());
        userRepository.save(user);
    }

    public void delete(UserAccount user) {
        Assert.notNull(user.getId());
        userRepository.delete(user);
    }

    public UserAccount getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
