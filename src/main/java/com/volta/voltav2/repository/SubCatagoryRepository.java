package com.volta.voltav2.repository;



import com.volta.voltav2.model.Catagory;
import com.volta.voltav2.model.SubCatagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SubCatagoryRepository extends JpaRepository<SubCatagory, Long> {

    @Query("SELECT s.sub_catagory from SubCatagory s WHERE s.sub_catagory_id = :sub_catagory_id")
    String getSubCatagoryById(@Param("sub_catagory_id") Long sub_catagory_id);

}


