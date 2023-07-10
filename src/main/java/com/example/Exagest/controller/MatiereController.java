package com.example.Exagest.controller;

import com.example.Exagest.Service.MatiereService;
import com.example.Exagest.entities.Eleve;
import com.example.Exagest.entities.Matiere;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/Matiere")
public class MatiereController {
  private final MatiereService matiereService;


    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    @PostMapping("/creeMatiere")
    Matiere ajouterMat(@RequestBody Matiere matiere){
        return matiereService.addmatiere(matiere);
    }
    @PutMapping("/editMatiere/{id}")
    Matiere modifInsc(@PathVariable("id") Long id, @RequestBody Matiere matiere){

        return matiereService.editmatiere(id,matiere);
    }

    @GetMapping("/getAllMatierelib")
    List<Matiere> matLib(){
        return matiereService.listMatLib();
    }

    @GetMapping("/getAllMatiereTypMat")
    List<Matiere> typMat(){
        return matiereService.listTypMat();
    }

    @GetMapping("/getMatPerElev")
    HashMap<String, List<Eleve>> matPerElv(){
        return matiereService.matPerElv();
    }


    @DeleteMapping("/suppMat/{id}")
    String suppInsc(@PathVariable("id") Long id){
        matiereService.deleteMatiere(id);
        return "Matiere supprimer avec succès";
    }
}
