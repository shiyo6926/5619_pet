package com.example.petback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping("/registered_pet_information")
    public ApiResponse registerPetInformation(@RequestBody Pet Pet) {
        Pet registeredPet = petService.registerPetInformation(Pet);

        if (registeredPet != null) {
            return new ApiResponse(true, "", "", registeredPet.getId());
        } else {
            return new ApiResponse(false, "incorrect_format", "error", "");
        }
    }
}
