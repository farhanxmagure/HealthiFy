package com.magure.HealthiFy.Security.Service;

import com.magure.HealthiFy.Security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.magure.HealthiFy.Security.Data.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find the user by username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        // Return a UserDetails object
        return UserDetailsImpl.build(user);
    }
}