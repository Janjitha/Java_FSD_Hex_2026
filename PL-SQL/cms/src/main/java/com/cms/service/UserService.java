package com.cms.service;

import com.cms.model.User;
import com.cms.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Fetching user details by given username {}", username);
        User user =  userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Invalid Credentials"));
        logger.info("User Details fetched for user {}", user.getUsername());
        return user;
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}

//package com.springboot.Management.service;
//
//
//import com.springboot.Management.repository.UserRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class UserService implements UserDetailsService {
//    private final UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        org.springframework.security.core.userdetails.User user=  userRepository.findByUsername(username)
//                .orElseThrow(()-> new UsernameNotFoundException("Invalid credentials"));
//        return user;
//    }
//
//    public org.springframework.security.core.userdetails.User save(org.springframework.security.core.userdetails.User user) {
//        return userRepository.save(user);
//    }
//}

