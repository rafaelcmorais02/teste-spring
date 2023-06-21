package com.teste.wedding.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.wedding.models.UserTest;
import com.teste.wedding.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository  userRepository;
    /**
     * Method to return a list of users
     * @return a list of users
     */
   public List<UserTest> getAll(){
        return userRepository.getAll();
   }

   /**
    * Method to return a user by id 
    * @param id is the unique identifier of a user
    * @return a user if the id exists
    */
   public Optional<UserTest> getById(UUID id){
        return userRepository.getById(id);
   }

   /**
    * Method to crate a user
    * @param user instance
    * @return the commited user instance
    */
   public UserTest create(UserTest user, UUID id) {
        return userRepository.create(user, id);
   }

   /**
    * Method to remove a user if exists
    * @param id is the unique identifier of a user 
    */
   public void delete(UUID id){
        userRepository.delete(id);
   }

   /**
    * Method to update a user
    * @param user to be updated
    * @return the updated user
    */
    public UserTest update(UserTest user, UUID id){
        return userRepository.update(user, id);
    }
}
