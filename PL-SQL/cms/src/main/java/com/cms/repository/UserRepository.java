package com.cms.repository;

import com.cms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
    // select * from User where username = ?1
}

//package com.springboot.Management.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.User;
//
//import java.util.Optional;
//
//public interface UserRepository extends JpaRepository<org.springframework.security.core.userdetails.User, Integer> {
//
//    Optional<org.springframework.security.core.userdetails.User> findByUsername(String username);
//}