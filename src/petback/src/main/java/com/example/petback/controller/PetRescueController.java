package com.example.petback.controller;
import com.example.petback.entity.PetRescue;
import com.example.petback.mapper.PetRescueMapper;
import com.example.petback.service.PetRescueService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/petrescue")
public class PetRescueController {
    private final PetRescueService petRescueService;

    @Autowired
    public PetRescueController(PetRescueService petRescueService) {
        this.petRescueService = petRescueService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPetRescue(@RequestBody PetRescue petRescue) {
        petRescueService.createPetRescue(petRescue);
        return new ResponseEntity<>("Pet Rescue created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/byCreator/{creatorID}")
    public ResponseEntity<List<PetRescue>> getRescuesByCreatorID(@PathVariable String creatorID) {
        List<PetRescue> rescues = petRescueService.getRescuesByCreatorID(creatorID);
        return new ResponseEntity<>(rescues, HttpStatus.OK);
    }

    @GetMapping("/byLocation/{location}")
    public ResponseEntity<List<PetRescue>> getRescuesByLocation(@PathVariable String location) {
        List<PetRescue> rescues = petRescueService.getRescuesByLocation(location);
        return new ResponseEntity<>(rescues, HttpStatus.OK);
    }

    @GetMapping("/byName/{rescueName}")
    public ResponseEntity<List<PetRescue>> getRescuesByName(@PathVariable String rescueName) {
        List<PetRescue> rescues = petRescueService.getRescuesByName(rescueName);
        return new ResponseEntity<>(rescues, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePetRescue(@RequestBody PetRescue petRescue) {
        petRescueService.updatePetRescue(petRescue);
        return new ResponseEntity<>("Pet Rescue updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePetRescue(@PathVariable Long id) {
        petRescueService.deletePetRescue(id);
        return new ResponseEntity<>("Pet Rescue deleted successfully", HttpStatus.OK);
    }
}
