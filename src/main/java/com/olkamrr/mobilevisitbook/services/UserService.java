package com.olkamrr.mobilevisitbook.services;

import com.olkamrr.mobilevisitbook.models.User;
import com.olkamrr.mobilevisitbook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAll(){
        List<User> users = new ArrayList<>();
        Streamable.of(userRepository.findAll()).forEach(users::add);
        return users;
    }

    public User findOne(int id) {
        User foundUser = userRepository.findById(id);
        return foundUser;
    }

}
