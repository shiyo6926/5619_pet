package com.example.petback.service;

import com.example.petback.entity.ExpertDialogue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ExpertDialogueServiceTest {
    @Autowired ExpertDialogueService expertDialogueService;
    @BeforeEach
    void setUp() {
    }

    @Test
    void receivedialogue() {
        //success
        ExpertDialogue expertDialogue1 =new ExpertDialogue(null,3790,10,"test");
        //empty
        ExpertDialogue expertDialogue2 =new ExpertDialogue(null,null,10,"test");
        ExpertDialogue expertDialogue3 =new ExpertDialogue(null,3790,null,"test");
        ExpertDialogue expertDialogue4 =new ExpertDialogue(null,3790,10,"");
        System.out.println(expertDialogueService.receivedialogue(expertDialogue1));
        System.out.println(expertDialogueService.receivedialogue(expertDialogue2));
        System.out.println(expertDialogueService.receivedialogue(expertDialogue3));
        System.out.println(expertDialogueService.receivedialogue(expertDialogue4));
    }

    @Test
    void senddialogue() {
        ExpertDialogue expertDialogue1 =new ExpertDialogue(null,null,10,null);
        //no expert or empty
        ExpertDialogue expertDialogue2 =new ExpertDialogue(null,null,10000,null);
        ExpertDialogue expertDialogue3 =new ExpertDialogue(null,null,null,"test");

        System.out.println(expertDialogueService.senddialogue(expertDialogue1));
        System.out.println(expertDialogueService.senddialogue(expertDialogue2));
        System.out.println(expertDialogueService.senddialogue(expertDialogue3));
    }
}