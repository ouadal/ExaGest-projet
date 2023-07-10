package com.example.Exagest.controller;

import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.requests.InscriptionRequestModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/Inscription")
public class InscriptionController {

    private final InscriptionService inscriptionService;

    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @PostMapping("/creeInscription")
    Inscription ajouterInsc(@RequestBody InscriptionRequestModel inscriptionRM){
        return inscriptionService.addinscription(inscriptionRM);
    }
    @PutMapping("/editInscription/{id}")
    Inscription modifInsc(@PathVariable("id") Long id, @RequestBody Inscription inscription){
//        compte.setId(id);
//        compte.setType(type);
//        compte.setDateCreation(dateCreation);
//        compte.setSolde(solde);
        return inscriptionService.editinscriptionn(id,inscription);
    }
//    @GetMapping("/consultCompte/{id}")
//    Compte consultCompt(@PathVariable("id") int id){
//        return compteService.consultCompte(id);
////                compteRepository.findById(id).get();
//    }
    @GetMapping("/getAllInscrEcol")
    List<Inscription> tousEco(){
        return inscriptionService.listEcol();
    }

    @GetMapping("/getAllInscrElev")
    List<Inscription> tousElev(){
        return inscriptionService.listElev();
    }


    @GetMapping("/getAllInscrAnn")
    List<Inscription> tousAnn(){
        return inscriptionService.listAnn();
    }


    @GetMapping("/getAllInscrEnrol")
    List<Inscription> tousEnrol(){
        return inscriptionService.listEnrol();
    }

    @GetMapping("/getAllInscrPerExam/{id}")
    List<Inscription> InscPerEx(@PathVariable("id") Long id){
        return inscriptionService.listInscPerExam(id);
    }

    @DeleteMapping("/suppInsc/{id}")
    String suppInsc(@PathVariable("id") Long id){
        inscriptionService.deleteinscription(id);
        return "Inscription supprimer avec succès";
    }
}
