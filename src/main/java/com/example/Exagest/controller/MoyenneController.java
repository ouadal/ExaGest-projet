package com.example.Exagest.controller;

import com.example.Exagest.Service.MoyenneService;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Moyenne;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Moyenne")
public class MoyenneController {
    private final MoyenneService moyenneService;

    public MoyenneController(MoyenneService moyenneService) {
        this.moyenneService = moyenneService;
    }


    @PostMapping("/creeMoyen")
    Moyenne ajouterMoyen(@RequestBody Moyenne moyenne){
        return moyenneService.addmoyenne(moyenne);
    }


    @PutMapping("/editMoyen/{id}")
    Moyenne modifInsc(@PathVariable("id") Long id, @RequestBody Moyenne moyenne){
        return moyenneService.editmoyenne(id,moyenne);
    }
    @GetMapping("/getAllMoyEcol")
    List<Moyenne> tousEco(){
        return moyenneService.listSess();
    }

    @GetMapping("/getAllMoyInsc")
    List<Moyenne> MoyInsc(){
        return moyenneService.listIns();
    }


    @GetMapping("/getAllMoyExam")
    List<Moyenne> MoyExam(){
        return moyenneService.listExam();
    }


    @GetMapping("/getAllMoySess")
    List<Moyenne> MoySess(){
        return moyenneService.listSess();
    }

    @DeleteMapping("/suppMoy/{id}")
    String suppInsc(@PathVariable("id") Long id){
        moyenneService.deletemoyenne(id);
        return "Moyenne supprimer avec succès";
    }
}
