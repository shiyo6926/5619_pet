package com.example.petback.mapper;

import com.example.petback.entity.PetProduct;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PetProductMapper {
    @Insert("INSERT INTO pet_product (user_id, product_name, tag, product_information) " +
            "VALUES (#{userId}, #{productName}, #{tag}, #{productInformation})")
    @Options(useGeneratedKeys = true, keyProperty = "productId")
    void insertPetProduct(PetProduct product);

    @Select("SELECT COUNT(*) FROM pet_product WHERE product_name = #{productName}")
    int countProductByName(String productName);
}

