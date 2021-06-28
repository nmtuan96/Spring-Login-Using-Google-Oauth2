package com.example.demo.config;

import com.example.demo.entities.AppUser;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<AppUser> user =userRepository.findByUsername(s);
        user.orElseThrow(()-> new UsernameNotFoundException("Not found: " + user));
        return new MyUserDetails(user.get());
    }
    public MyUserDetails buildUserDetailsFromOauth2User(OAuth2User oAuth2User) {
        return new MyUserDetails(oAuth2User);
    }
}
