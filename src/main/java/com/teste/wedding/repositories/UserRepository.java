package com.teste.wedding.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.teste.wedding.models.UserTest;

public interface UserRepository extends JpaRepository<UserTest, UUID> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update UserTest u set u.name = :name, u.email = :email where u.id = :id")
    void updateUser(@Param("name") String name, @Param("email") String email, @Param("id") UUID id);
}
