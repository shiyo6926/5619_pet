package com.example.petback.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.petback.mapper.PetRescueMapper;
import com.example.petback.entity.PetRescue;

import java.util.List;

@Service
public class PetRescueService {
    private final PetRescueMapper petRescueMapper;

    public PetRescueService(PetRescueMapper petRescueMapper) {
        this.petRescueMapper = petRescueMapper;
    }

    @Transactional
    public void createPetRescue(PetRescue petRescue) {
        petRescueMapper.createPetRescue(petRescue);
    }

    public List<PetRescue> getRescuesByCreatorID(String creatorID) {
        return petRescueMapper.getRescuesByCreatorID(creatorID);
    }


    public List<PetRescue> getRescuesByLocation(String location) {
        return petRescueMapper.getRescuesByLocation(location);
    }

    public List<PetRescue> getRescuesByName(String rescueName) {
        return petRescueMapper.getRescuesByName(rescueName);
    }


    @Transactional
    public void updatePetRescue(PetRescue petRescue) {
        petRescueMapper.updatePetRescue(petRescue);
    }

    @Transactional
    public void deletePetRescue(Long id) {
        petRescueMapper.deletePetRescue(id);
    }
}
