package com.example.petback.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.petback.entity.PetRescue;

import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PetRescueMapper {
    @Insert("INSERT INTO pet_rescue (creatorID, rescueName, rescueDescription, date, location) VALUES (#{creatorID}, #{rescueName}, #{rescueDescription}, #{date}, #{location})")
    void createPetRescue(PetRescue petRescue);

    @Select("SELECT * FROM pet_rescue WHERE creatorID = #{creatorID}")
    List<PetRescue> getRescuesByCreatorID(String creatorID);



    @Select("SELECT * FROM pet_rescue WHERE location = #{location}")
    List<PetRescue> getRescuesByLocation(String location);

    @Select("SELECT * FROM pet_rescue WHERE rescueName = #{rescueName}")
    List<PetRescue> getRescuesByName(String rescueName);
    @Update("UPDATE pet_rescue SET creatorID = #{creatorID}, rescueName = #{rescueName}, rescueDescription = #{rescueDescription}, date = #{date}, location = #{location} WHERE id = #{id}")
    void updatePetRescue(PetRescue petRescue);
    @Delete("DELETE FROM pet_rescue WHERE id = #{id}")
    void deletePetRescue(Long id);



}
