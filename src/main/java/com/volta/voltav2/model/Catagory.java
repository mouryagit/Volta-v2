package com.volta.voltav2.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Catagory {
    private Long catagory_id;
    private String catagory;
    public Catagory(Long catagory_id, String catagory) {
        this.catagory_id = catagory_id;
        this.catagory = catagory;

    }

    public Catagory() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCatagory_id() {
        return catagory_id;
    }

    public String getCatagory() {
        return catagory;
    }



    public void setCatagory_id(Long id) {
        this.catagory_id = id;
    }

    public void setCatagory(String username) {
        this.catagory = username;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + catagory_id +
                ", username='" + catagory + '\'' +
                '}';
    }
}
