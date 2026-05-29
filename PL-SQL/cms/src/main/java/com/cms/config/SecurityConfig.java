package com.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService users() {
        UserDetails user1 = User.builder()
                .username("john_doe")
                .password("{noop}password123")
                .roles("OFFICER")
                .build();
        UserDetails user2 = User.builder()
                .username("robert_davids")
                .password("{noop}pass123")
                .roles("STATION_HEAD")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }
}