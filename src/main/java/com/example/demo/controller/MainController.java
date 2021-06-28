package com.example.demo.controller;

import com.example.demo.config.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping("/admin")
    public String index(Authentication authentication){
        if(authentication.getAuthorities() instanceof MyUserDetails){
            MyUserDetails user = (MyUserDetails) authentication.getPrincipal();
            System.out.println(user.getUsername());
            System.out.println(user.getAuthorities());
            System.out.println(user.getEmail());
        }
        return "Hello";
    }
}
