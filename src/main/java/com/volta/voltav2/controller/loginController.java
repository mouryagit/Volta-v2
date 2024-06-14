package com.volta.voltav2.controller;

import com.volta.voltav2.model.Catagory;
import com.volta.voltav2.model.User;
import com.volta.voltav2.repository.CatagoryRepository;
import com.volta.voltav2.repository.UserRepository;
import com.volta.voltav2.service.CatagoryService;
import com.volta.voltav2.service.SubCatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/")
public class loginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CatagoryRepository catagoryRepository;

    @Autowired
    CatagoryService catagoryService;

    @Autowired
    SubCatagoryService subCatagoryService;


    @GetMapping("/getCatagory/{catagory_id}")
    public String getCatagory(@PathVariable Long catagory_id){
        return catagoryService.getCatagoryById(catagory_id);

    }

    @GetMapping("/getSubCatagory/{sub_catagory_id}")
    public String getSubCatagory(@PathVariable Long sub_catagory_id){

        return subCatagoryService.getSubCatagoryById(sub_catagory_id);

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
