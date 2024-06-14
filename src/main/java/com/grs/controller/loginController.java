package com.grs.controller;

import com.grs.model.User;
import com.grs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/")
public class loginController {

    @Autowired
    UserRepository userRepository;




    @GetMapping("/getCurrentUser")
     public List<User> getCurrentUser(){
        return userRepository.findAll();
    }

    @PostMapping("/createUsers")
    public String createUsers(@RequestBody User user){
        userRepository.save(user);
        return "New User has been created with "+user.toString() +" and the Role is "+user.getRole();

    }
}
