package com.g19.fitter.database;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserService {

    @Autowired
    private UserAccountRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Role getRole(String role) {
        return roleRepository.findOne(role);
    }

    public boolean create(UserAccount user) {
        Assert.isNull(user.getId());

        // duplicate username
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return false;
        }
        user.setApiKey(UUID.randomUUID().toString());
        user.setEnabled(true);
        user.setStatus(UserAccountStatus.STATUS_APPROVED.name());
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

    public UserAccount getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}