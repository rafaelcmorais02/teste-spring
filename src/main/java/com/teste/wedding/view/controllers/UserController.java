package com.teste.wedding.view.controllers;

import java.util.List;
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

import com.teste.wedding.services.UserService;
import com.teste.wedding.shared.UserDTO;

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
    public List<UserDTO> getAll(){
        return userService.getAll();
    }


    /**
    * Method to crate a user
    * @param user instance
    * @return the commited user instance
    */
    @PostMapping
    public UserDTO create(@RequestBody UserDTO user) {
        return userService.create(user);
    }
    
    /**
    * Method to return a user by id 
    * @param id is the unique identifier of a user
    * @return a user if the id exists
    */

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable UUID id){
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
    public void update(@RequestBody UserDTO user, @PathVariable UUID id){
        userService.update(user, id);
    }
}
