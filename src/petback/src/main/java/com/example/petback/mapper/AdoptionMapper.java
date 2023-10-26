package com.example.petback.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.petback.entity.Adoption;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdoptionMapper {

    @Insert("INSERT INTO adoption (creatorID, adoptorID, petName, tag, age, gender, adoptionStatus) " +
            "VALUES (#{creatorID}, #{adoptorID}, #{petName}, #{tag}, #{age}, #{gender}, #{adoptionStatus})")
    void createAdoption(Adoption adoption);


    @Select("SELECT * FROM adoption WHERE adoptorID = #{adoptorID}")
    List<Adoption> getAdoptionsByAdoptorID(String adoptorID);

    @Select("SELECT * FROM adoption WHERE petName = #{petName}")
    List<Adoption> getAdoptionsByPetName(String petName);

    @Update("UPDATE adoption " +
            "SET creatorID = #{creatorID}, adoptorID = #{adoptorID}, petName = #{petName}, " +
            "tag = #{tag}, age = #{age}, gender = #{gender}, adoptionStatus = #{adoptionStatus} " +
            "WHERE id = #{id}")
    void updateAdoption(Adoption adoption);

    @Delete("DELETE FROM adoption WHERE id = #{id}")
    void deleteAdoption(int id);
}
