package com.spring.springsecurity.services;

import com.spring.springsecurity.entities.User;
import com.spring.springsecurity.models.CustomUserDetails;
import com.spring.springsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;
@Service
public class JpaUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s =
                () -> new UsernameNotFoundException(
                        "Problem during authentication!");
        User u = userRepository
                .findUserByUsername(username)
                .orElseThrow(s);
        return new CustomUserDetails(u);
    }
}
