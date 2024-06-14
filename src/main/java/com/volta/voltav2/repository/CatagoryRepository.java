package com.volta.voltav2.repository;



import com.volta.voltav2.model.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface CatagoryRepository extends JpaRepository<Catagory, Long> {

    @Query("SELECT c.catagory from Catagory c WHERE c.catagory_id = :catagory_id")
    String getCatagoryById(@Param("catagory_id") Long catagory_id);

}


