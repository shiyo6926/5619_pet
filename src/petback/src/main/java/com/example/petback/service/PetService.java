package com.example.petback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet registerPetInformation(Pet pet) {
        // 在这里可以添加检查是否为空和格式的逻辑
        if (pet.getPetName() == null || pet.getPetName().isEmpty() ||
                pet.getTag() == null || !("cat".equals(pet.getTag()) || "dog".equals(pet.getTag())) ||
                ) {
            return null; // 返回null表示信息格式不正确
        }

        // 存储宠物信息到数据库
        Pet savedPet = petRepository.save(pet);

        return savedPet;
    }
}

