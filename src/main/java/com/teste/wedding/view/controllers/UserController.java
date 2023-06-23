package com.teste.wedding.view.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.teste.wedding.view.models.UserRequest;
import com.teste.wedding.view.models.UserResponse;

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
    public ResponseEntity<List<UserResponse>> getAll(){
        List<UserDTO> usersDto = userService.getAll();
        List<UserResponse> usersResponse = usersDto.stream().map(user->new ModelMapper().map(user, UserResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(usersResponse, HttpStatus.OK);  
    }


    /**
    * Method to crate a user
    * @param user instance
    * @return the commited user instance
    */
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest user) {
        UserDTO userDto = new ModelMapper().map(user, UserDTO.class); 
        userDto = userService.create(userDto);
        return new ResponseEntity<>(new ModelMapper().map(userDto, UserResponse.class), HttpStatus.CREATED);
    }
    
    /**
    * Method to return a user by id 
    * @param id is the unique identifier of a user
    * @return a user if the id exists
    */

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable UUID id){
            UserDTO userDto = userService.getById(id);
            return new ResponseEntity<>(new ModelMapper().map(userDto, UserResponse.class), HttpStatus.OK) ;
    }

    /**
    * Method to remove a user if exists
    * @param id is the unique identifier of a user 
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }

   /**
    * Method to update a user
    * @param user to be updated
    * @return the updated user
    */
    @PutMapping("/{id}")
    public ResponseEntity<?>  update(@RequestBody UserRequest user, @PathVariable UUID id){
        UserDTO userDto = new ModelMapper().map(user, UserDTO.class);
        userService.update(userDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
