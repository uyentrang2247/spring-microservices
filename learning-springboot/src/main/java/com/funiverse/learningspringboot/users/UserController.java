package com.funiverse.learningspringboot.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    private UserDAOService userDAOService = new UserDAOService();

    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
        return userDAOService.getUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id){
        return userDAOService.findOne(id);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> addUser(@RequestBody User user){
        User savedUser = userDAOService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
        User deleteUser = userDAOService.deleteUser(id);
//        if (deleteUser == null) throw new UserNotFoundException("id-"+id);
    }
}
