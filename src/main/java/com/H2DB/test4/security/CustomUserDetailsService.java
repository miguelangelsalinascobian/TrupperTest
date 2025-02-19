package com.H2DB.test4.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import java.util.List;

@Configuration
public class CustomUserDetailsService {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("usuarioEjemplo")
                .password("{noop}password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(List.of(user));
    }
}
