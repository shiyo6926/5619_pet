package com.example.petback.mapper;

import com.example.petback.entity.PetProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PetProductMapper {
    @Select("SELECT * FROM product")
    List<PetProduct> getPetProducts();

    @Select("SELECT * FROM product WHERE pet = #{pet}")
    List<PetProduct> getPetProductsbypet(String pet);
}

