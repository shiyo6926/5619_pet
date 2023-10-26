package com.example.petback.service;

import com.example.petback.entity.PetDiary;
import com.example.petback.mapper.PetDiaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PetDiaryService {

    @Autowired
    private PetDiaryMapper petDiaryMapper;

    public PetDiary addPetDiary(PetDiary petDiary) {
        // 检查参数是否为空

        if (Objects.equals(petDiary.getUserId(),null) || Objects.equals(petDiary.getUserId(),"")) {
            petDiary.setReason("Error: UserId is missing");
            return petDiary;
        }

        if (petDiary.getValue() == null || petDiary.getValue().isEmpty()) {
            petDiary.setReason("Error: Value is missing");
            return petDiary;
        }

        // 调用 Mapper 插入数据
        petDiaryMapper.addPetDiary(petDiary);
        List <PetDiary> getPetDiarylist = petDiaryMapper.getPetDiaryList(petDiary);
        return getPetDiarylist.get(0);
    }



    public PetDiary editPetDiary(PetDiary petDiary) {
        // 检查参数是否为空

        if (Objects.equals(petDiary.getUserId(),null) || Objects.equals(petDiary.getUserId(),"")) {
            petDiary.setReason("Error: UserId is missing");
            return petDiary;
        }

        if (petDiary.getValue() == null || petDiary.getValue().isEmpty()) {
            petDiary.setReason("Error: Value is missing");
            return petDiary;
        }

        if (Objects.equals(petDiary.getPetDiaryId(),null) || Objects.equals(petDiary.getPetDiaryId(),"")) {
            petDiary.setReason("Error: PetDiaryId is missing");
            return petDiary;
        }


        petDiaryMapper.updatePetDiary(petDiary);
        petDiary.setReason("successful");
        return petDiary;
    }


    public PetDiary deletePetDiary(PetDiary petDiary) {
        // 检查参数是否为空

        if (Objects.equals(petDiary.getUserId(),null) || Objects.equals(petDiary.getUserId(),"")) {
            petDiary.setReason("Error: UserId is missing");
            return petDiary;
        }
        if (Objects.equals(petDiary.getPetDiaryId(),null) || Objects.equals(petDiary.getPetDiaryId(),"")) {
            petDiary.setReason("Error: PetDiaryId is missing");
            return petDiary;
        }

        // 调用 Mapper 删除数据
        petDiaryMapper.deletePetDiary(petDiary);
        petDiary.setReason("successful");
        return petDiary;
    }

    public List<PetDiary> getPetDiariesByUserId(int userId) {
        // 检查参数是否为空
        List<PetDiary> listbyuser =new ArrayList<>();;
        if (Objects.equals(userId,null) || Objects.equals(userId,"")) {
            listbyuser.get(0).setReason("Error: UserId is missing");
            return listbyuser;
        }


        // 调用 Mapper 获取数据
        return petDiaryMapper.getPetDiariesByUserId(userId);
    }



}

