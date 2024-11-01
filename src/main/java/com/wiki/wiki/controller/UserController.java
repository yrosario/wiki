package com.wiki.wiki.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
