package com.funiverse.learningspringboot.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException {
//    public UserNotFoundException(String message) {
//        super(message);
//    }
}
