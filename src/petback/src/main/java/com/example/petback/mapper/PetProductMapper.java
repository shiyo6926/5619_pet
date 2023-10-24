package com.example.petback.mapper;

import com.example.petback.entity.PetProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PetProductMapper {
    @Select("SELECT * FROM petproduct")
    List<PetProduct> getPetProducts();

    @Select("SELECT COUNT(*) FROM petproduct WHERE tag = #{tag}")
    List<PetProduct> getPetProductsbytag(String tag);
}

