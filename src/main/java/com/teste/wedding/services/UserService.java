package com.teste.wedding.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.wedding.models.UserTest;
import com.teste.wedding.models.exceptions.ResourceNotFoundException;
import com.teste.wedding.repositories.UserRepository;
import com.teste.wedding.shared.UserDTO;

@Service
public class UserService {
     @Autowired
     private UserRepository  userRepository;
     /**
     * Method to return a list of users
     * @return a list of users
     */
     public List<UserDTO> getAll(){
          List<UserTest> users = userRepository.findAll();
          return users.stream().
          map(user -> new ModelMapper().map(user, UserDTO.class)).
          collect(Collectors.toList());
     }

     /**
      * Method to return a user by id 
     * @param id is the unique identifier of a user
     * @return a user if the id exists
     */
     public UserDTO getById(UUID id){
          Optional<UserTest> user = userRepository.findById(id);
          if(user.isEmpty()){
               throw new ResourceNotFoundException("User with id: "+id+" not found");
          }
          return new ModelMapper().map(user.get(), UserDTO.class); 
     }

     /**
      * Method to crate a user
     * @param user instance
     * @return the commited user instance
     */
     public UserDTO create(UserDTO user) {
          UserTest userTest =  userRepository.save(new ModelMapper().map(user, UserTest.class));
          return new ModelMapper().map(userTest, UserDTO.class);
     }

     /**
      * Method to remove a user if exists
     * @param id is the unique identifier of a user 
     */
     public void delete(UUID id){
          userRepository.deleteById(id);
     }

     /**
      * Method to update a user
     * @param user to be updated
     * @return the updated user
     */
     public void update(UserDTO user, UUID id){
          userRepository.updateUser(user.getName(), user.getEmail(), id);
     }
}
