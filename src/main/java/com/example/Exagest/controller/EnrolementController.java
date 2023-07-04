package com.example.Exagest.controller;

import com.example.Exagest.Service.EnrolementService;
import com.example.Exagest.entities.Enrolement;
import com.example.Exagest.entities.Inscription;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/Enrolement")
@RestController
public class EnrolementController {
    private final EnrolementService enrolementService;

    public EnrolementController(EnrolementService enrolementService) {
        this.enrolementService = enrolementService;
    }


    @PostMapping("/creeEnrolement")
    Enrolement ajouterEnrol(@RequestBody Enrolement enrolement){
        return enrolementService.addenrolement(enrolement);
    }

    @PutMapping("/editenrol/{id}")
    Enrolement modifEnrol(@PathVariable("id") Long id, @RequestBody Enrolement enrolement){
        return enrolementService.editenrolement(id,enrolement);
    }

    @GetMapping("/getAllEnrolEcol")
    List<Enrolement> EnrolEco(){
        return enrolementService.listEcol();
    }

    @GetMapping("/getAllEnrolExam")
    List<Enrolement> EnrolExam(){
        return enrolementService.listExamen();
    }


    @DeleteMapping("/suppEnrol/{id}")
    String suppEnrol(@PathVariable("id") Long id){
        enrolementService.deleteenrolement(id);
        return "enrolement supprimer avec succès";
    }
}
