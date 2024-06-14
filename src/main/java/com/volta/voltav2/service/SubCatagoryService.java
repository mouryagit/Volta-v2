package com.volta.voltav2.service;

import com.volta.voltav2.repository.CatagoryRepository;
import com.volta.voltav2.repository.SubCatagoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCatagoryService {

    @Autowired
    SubCatagoryRepository subCatagoryRepository;

    public String getSubCatagoryById(Long sub_catagory_id ){
        return subCatagoryRepository.getSubCatagoryById(sub_catagory_id);
    }
}
