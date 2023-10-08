package com.example.petback.mapper;

import com.example.petback.entity.petdiary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PetMapper {
    @Insert("INSERT INTO pet(petName, tag) VALUES (#{petName}, #{tag})")
    int registerPet(petdiary pet);
}
