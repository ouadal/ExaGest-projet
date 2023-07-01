package com.example.Exagest.controller;

import com.example.Exagest.Service.CycleTypeExamenService;
import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.CycleTypeExamen;
import com.example.Exagest.entities.Inscription;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/CycleType")
public class CycleTypeExamenController {
    private final CycleTypeExamenService cycleTypeExamenService;

    public CycleTypeExamenController(CycleTypeExamenService cycleTypeExamenService) {
        this.cycleTypeExamenService = cycleTypeExamenService;
    }


    @PostMapping("/creeCycle")
    CycleTypeExamen ajouterCyc(@RequestBody CycleTypeExamen cycleTypeExamen){
        return cycleTypeExamenService.addcycleTypeExam(cycleTypeExamen);
    }

    @PutMapping("/editInscription/{id}")
    CycleTypeExamen modifInsc(@PathVariable("id") Long id, @RequestBody CycleTypeExamen cycleTypeExamen){
        return cycleTypeExamenService.editcycleTypeExam(id,cycleTypeExamen);
    }

    @GetMapping("/getAllCycle")
    List<CycleTypeExamen> tousEco(@RequestBody CycleTypeExamen cycleTypeExamen){
        return cycleTypeExamenService.listcycleTypeExam();
    }

    @DeleteMapping("/suppCycleType/{id}")
    String suppcycle(@PathVariable("id") Long id){
        cycleTypeExamenService.deletecycleTypeExam(id);
        return "Cycle type examen supprimer avec succès";
    }

}
