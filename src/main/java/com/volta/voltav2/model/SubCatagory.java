package com.volta.voltav2.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubCatagory {
    private Long sub_catagory_id;
    private String sub_catagory;
    public SubCatagory(Long catagory_id, String catagory) {
        this.sub_catagory_id = catagory_id;
        this.sub_catagory = catagory;

    }

    public SubCatagory() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getSub_catagory_id() {
        return sub_catagory_id;
    }

    public String getSub_catagory() {
        return sub_catagory;
    }



    public void setSub_catagory_id(Long id) {
        this.sub_catagory_id = id;
    }

    public void setSub_catagory(String username) {
        this.sub_catagory = username;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + sub_catagory_id +
                ", username='" + sub_catagory + '\'' +
                '}';
    }
}
