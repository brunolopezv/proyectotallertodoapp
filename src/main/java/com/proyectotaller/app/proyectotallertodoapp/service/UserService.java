package com.proyectotaller.app.proyectotallertodoapp.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.proyectotaller.app.proyectotallertodoapp.model.User;
import com.proyectotaller.app.proyectotallertodoapp.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
   
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    // public User update(Long id,String titulo) {
    //     return userRepository.update(id,titulo);
    // }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

}
