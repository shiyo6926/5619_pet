package com.example.petback.mapper;

import com.example.petback.entity.PetDiary;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PetDiaryMapper {

    @Insert("INSERT INTO petdiary (date, userId, value) VALUES (#{date}, #{userId}, #{value})")
    void addPetDiary(PetDiary petDiary);
    @Select("SELECT * FROM petdiary WHERE userId = #{userId} AND date=#{date} AND value = #{value}")
    List <PetDiary> getPetDiaryList(PetDiary petDiary);
    @Update("UPDATE petdiary SET date = #{date}, value = #{value} WHERE petDiaryId = #{petDiaryId}")
    void updatePetDiary(PetDiary petDiary);

    @Delete("DELETE FROM petdiary WHERE petDiaryId = #{petDiaryId} AND userId = #{userId}")
    void deletePetDiary(PetDiary petDiary);

    @Select("SELECT * FROM petdiary WHERE userId = #{userId}")
    List<PetDiary> getPetDiariesByUserId(int userId);
}
