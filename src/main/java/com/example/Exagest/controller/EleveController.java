package com.example.Exagest.controller;

import com.example.Exagest.Service.EleveService;
import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.Eleve;
import com.example.Exagest.entities.Inscription;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Eleve")
public class EleveController {
    private final EleveService eleveService;


    public EleveController(EleveService eleveService) {
        this.eleveService = eleveService;
    }

    @PostMapping("/creeEleve")
    Eleve ajouterElev(@RequestBody Eleve eleve){
        return eleveService.addeleve(eleve);
    }
    @PutMapping("/editInscription/{id}")
    Eleve modifElev(@PathVariable("id") Long id, @RequestBody Eleve eleve){
        return eleveService.editeleve(id,eleve);
    }

    @GetMapping("/getAllElev")
    List<Eleve> tousElev(@RequestBody Eleve eleve){
        return eleveService.listNom();
    }


    @DeleteMapping("/suppElev/{id}")
    String suppElev(@PathVariable("id") Long id){
        eleveService.deleteeleve(id);
        return "Inscription supprimer avec succès";
    }
}
