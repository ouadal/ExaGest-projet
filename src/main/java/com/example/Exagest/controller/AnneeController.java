package com.example.Exagest.controller;

import com.example.Exagest.Service.AnneeService;
import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Inscription;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/Annee")
public class AnneeController {
    private final AnneeService anneeService;

    public AnneeController(AnneeService anneeService) {
        this.anneeService = anneeService;
    }

    @PostMapping("/creeAnnee")
    Annee ajouterann(@RequestBody Annee annee){
        return anneeService.addAnnee(annee);
    }
    @PutMapping("/editAnnee/{id}")
    Annee modifann(@PathVariable("id") Long id, @RequestBody Annee annee){
        return anneeService.editAnnee(id,annee);
    }

    @GetMapping("/getAllAnn")
    List<Annee> tousEco(@RequestBody Annee annee){
        return anneeService.listAnne();
    }

    @DeleteMapping("/suppAnn/{id}")
    String suppAnn(@PathVariable("id") Long id){
        anneeService.deleteAnnee(id);
        return "Annee supprimer avec succès";
    }
}
