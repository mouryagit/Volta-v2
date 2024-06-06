package com.volta.voltav2.controller;

import com.volta.voltav2.model.User;
import com.volta.voltav2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/")
public class loginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/test")
    public String test(){
        return "Test Dataaaaaaa";

    }
    @GetMapping("/getCurrentUser")
     public List<User> getCurrentUser(){
        System.out.println("11111111111111111111111111 tyrying to getdata from db");
        return userRepository.findAll();
    }

    @PostMapping("/createUsers")
    public String createUsers(@RequestBody User user){
        userRepository.save(user);
        return "New User has been created with "+user.toString() +" and the Role is "+user.getRole();

    }
}
