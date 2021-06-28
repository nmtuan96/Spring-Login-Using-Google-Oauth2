package com.example.demo;

import com.example.demo.entities.AppUser;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AppUser appUser = new AppUser(null, "admin", "1", "ROLE_ADMIN","neu.nganhang@gmail.com");
        userRepository.save(appUser);
    }
}
