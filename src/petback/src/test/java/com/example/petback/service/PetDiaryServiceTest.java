package com.example.petback.service;

import com.example.petback.entity.PetDiary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class PetDiaryServiceTest {
@Autowired
PetDiaryService petDiaryService;
    @BeforeEach
    void setUp() {
    }

    @Test
    void addPetDiary() {
        //succuss
        PetDiary petDiary1 = new PetDiary(0, 11, "一月11号","今天去外面","successful");
        //null
        PetDiary petDiary2 = new PetDiary(0, 11, "一月11号",null,"Error: Value is missing");
        PetDiary petDiary3 = new PetDiary(0, 0, "一月11号","今天去外面","Error: UserId is missing");
        //empty
        PetDiary petDiary4 = new PetDiary(0, 11, "一月11号"," ","Error: Value is missing");
        PetDiary petDiary5 = new PetDiary(0, 0 , "一月11号","今天去外面","Error: UserId is missing");

        System.out.println(petDiaryService.addPetDiary(petDiary1));
        System.out.println(petDiaryService.addPetDiary(petDiary2));
        System.out.println(petDiaryService.addPetDiary(petDiary3));
        System.out.println(petDiaryService.addPetDiary(petDiary4));
        System.out.println(petDiaryService.addPetDiary(petDiary5));
    }

    @Test
    void editPetDiary() {
        //success
        PetDiary petDiary1 = new PetDiary(1, 11, "一月11号","今天去外面","successful");
        //null
        PetDiary petDiary2 = new PetDiary(1, 11, "一月11号",null,"Error: Value is missing");
        PetDiary petDiary3 = new PetDiary(1, 0, "一月11号","今天去外面","Error: UserId is missing");
        PetDiary petDiary4 = new PetDiary(0, 11, "一月11号","今天去外面","Error: PetDiaryId is missing");
        //empty
        PetDiary petDiary5= new PetDiary(1, 11, "一月11号"," ","Error: Value is missing");
        PetDiary petDiary6 = new PetDiary(1, 0 , "一月11号","今天去外面","Error: UserId is missing");
        PetDiary petDiary7 = new PetDiary(0, 11, "一月11号","今天去外面","Error: PetDiaryId is missing");

        System.out.println(petDiaryService.addPetDiary(petDiary1));
        System.out.println(petDiaryService.addPetDiary(petDiary2));
        System.out.println(petDiaryService.addPetDiary(petDiary3));
        System.out.println(petDiaryService.addPetDiary(petDiary4));
        System.out.println(petDiaryService.addPetDiary(petDiary5));
        System.out.println(petDiaryService.addPetDiary(petDiary6));
        System.out.println(petDiaryService.addPetDiary(petDiary7));
    }

    @Test
    void deletePetDiary() {
        //success
        PetDiary petDiary1 = new PetDiary(1, 11, "一月11号","今天去外面","successful");
        //null
        PetDiary petDiary3 = new PetDiary(1, 0, "一月11号","今天去外面","Error: UserId is missing");
        PetDiary petDiary4 = new PetDiary(0, 11, "一月11号","今天去外面","Error: PetDiaryId is missing");
        //empty
        PetDiary petDiary6 = new PetDiary(1, 0 , "一月11号","今天去外面","Error: UserId is missing");
        PetDiary petDiary7 = new PetDiary(0, 11, "一月11号","今天去外面","Error: PetDiaryId is missing");

        System.out.println(petDiaryService.addPetDiary(petDiary1));
        System.out.println(petDiaryService.addPetDiary(petDiary3));
        System.out.println(petDiaryService.addPetDiary(petDiary4));
        System.out.println(petDiaryService.addPetDiary(petDiary6));
        System.out.println(petDiaryService.addPetDiary(petDiary7));
    }

    @Test
    void getPetDiariesByUserId() {
        //success
        PetDiary petDiary1 = new PetDiary(1, 11, "一月11号","今天去外面","successful");
        //null
        PetDiary petDiary3 = new PetDiary(1, 0, "一月11号","今天去外面","Error: UserId is missing");
        //empty
        PetDiary petDiary6 = new PetDiary(1, 0 , "一月11号","今天去外面","Error: UserId is missing");

        System.out.println(petDiaryService.addPetDiary(petDiary1));
        System.out.println(petDiaryService.addPetDiary(petDiary3));
        System.out.println(petDiaryService.addPetDiary(petDiary6));
    }
}