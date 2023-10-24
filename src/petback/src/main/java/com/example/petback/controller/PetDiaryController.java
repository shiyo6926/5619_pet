package com.example.petback.controller;

import com.example.petback.entity.PetDiary;
import com.example.petback.service.PetDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petdiary")
public class PetDiaryController {

    @Autowired
    private PetDiaryService petDiaryService;

    @PostMapping("/add")
    public PetDiary addPetDiary(
            @RequestBody PetDiary petdiary) {
        PetDiary response = petDiaryService.addPetDiary(petdiary);
        return response;
    }

    @PostMapping("/edit")
    public PetDiary editPetDiary(
            @RequestBody PetDiary petdiary) {

        PetDiary response = petDiaryService.editPetDiary(petdiary);
        return response;
    }

    @PostMapping("/delete")
    public PetDiary deletePetDiary(
            @RequestBody PetDiary petdiary) {
        PetDiary response = petDiaryService.deletePetDiary(petdiary);
        return response;
    }

    @GetMapping("/get")
    public ResponseEntity<List<PetDiary>> getPetDiariesByUserId(@RequestParam int userId) {

        List<PetDiary> petDiaries = petDiaryService.getPetDiariesByUserId(userId);
        return ResponseEntity.ok(petDiaries);
    }
}
