package com.teste.wedding.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.teste.wedding.models.UserTest;

@Repository
public class UserRepository_old {
    private List<UserTest> users = new ArrayList<UserTest>();

    /**
     * Method to return a list of users
     * @return a list of users
     */
    public List<UserTest> getAll(){
        return users;
   }

   /**
    * Method to return a user by id 
    * @param id is the unique identifier of a user
    * @return a user if the id exists
    */
   public Optional<UserTest> getById(UUID id){
        return users.stream().filter(user->user.getId().equals(id)).findFirst();
   }

   /**
    * Method to crate a user
    * @param user instance
    * @return the commited user instance
    */
   public UserTest create(UserTest user, UUID id) {
        if(id != null) {
            user.setId(id);
        }
        else{
            user.setId(UUID.randomUUID());
        } 
        users.add(user);
        return user;
   }

   /**
    * Method to remove a user if exists
    * @param id is the unique identifier of a user 
    */
   public void delete(UUID id){
        users.removeIf(user -> user.getId().equals(id));
   }

   /**
    * Method to update a user
    * @param user to be updated
    * @return the updated user
    */
    public UserTest update(UserTest user, UUID id){
        delete(id);
        return create(user, id);
    }
}
