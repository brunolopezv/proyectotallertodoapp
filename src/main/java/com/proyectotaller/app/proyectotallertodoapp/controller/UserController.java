package com.proyectotaller.app.proyectotallertodoapp.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.proyectotaller.app.proyectotallertodoapp.model.User;
import com.proyectotaller.app.proyectotallertodoapp.service.UserService;

@RestController
@RequestMapping("/api")

public class UserController {
      
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(SpringDataWebProperties.Pageable pageable) {
        logger.info("REST request to get a page of Users");
        List<User> allUsers = userService.findAll();
        return ResponseEntity.ok().body(allUsers);
    }
}