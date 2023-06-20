package com.teste.wedding.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.wedding.models.User;
import com.teste.wedding.services.UserService;

@RestController
@RequestMapping("/api/v1/users")

public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Method to return a list of users
     * @return a list of users
     */
    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }


    /**
    * Method to crate a user
    * @param user instance
    * @return the commited user instance
    */
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user, null);
    }
    
    /**
    * Method to return a user by id 
    * @param id is the unique identifier of a user
    * @return a user if the id exists
    */

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable UUID id){
            return userService.getById(id);
    }

    /**
    * Method to remove a user if exists
    * @param id is the unique identifier of a user 
    */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
            userService.delete(id);
    }

   /**
    * Method to update a user
    * @param user to be updated
    * @return the updated user
    */
    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable UUID id){
        return userService.update(user, id);
    }
}
