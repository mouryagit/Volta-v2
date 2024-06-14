package com.volta.voltav2.service;

import com.volta.voltav2.model.Catagory;
import com.volta.voltav2.repository.CatagoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatagoryService {

    @Autowired
    CatagoryRepository catagoryRepository;

    public String getCatagoryById(Long catagory_id ){
        return catagoryRepository.getCatagoryById(catagory_id);
    }
}
