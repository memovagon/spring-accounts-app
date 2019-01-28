package com.accounts.app.models.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.accounts.app.models.entity.User;
import com.accounts.app.models.repositories.IUserRepository;

/**
 *  @Service AutorizationServerConfig class
 *  AutorizationServerConfig class provide service layer implementation for User.  
 */

@Service
public class UserService {

    @Autowired
    private IUserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

}