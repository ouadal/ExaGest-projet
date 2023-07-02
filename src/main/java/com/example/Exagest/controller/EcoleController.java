package com.example.Exagest.controller;

import com.example.Exagest.Service.EcoleService;
import com.example.Exagest.entities.Ecole;
import com.example.Exagest.entities.Inscription;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/Ecole")
@RestController
public class EcoleController {
    private final EcoleService ecoleService;

    public EcoleController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    @PostMapping("/creeEcole")
    Ecole ajouterEcol(@RequestBody Ecole ecole){
        return ecoleService.addecole(ecole);
    }
    @PutMapping("/editecole/{id}")
    Ecole modifEcol(@PathVariable("id") Long id, @RequestBody Ecole ecole){
        return ecoleService.editecole(id,ecole);
    }

    @GetMapping("/getAllEcolCycle")
    List<Ecole> EcoCyc(){
        return ecoleService.listEcolCycle();
    }

    @GetMapping("/getAllEcolNom")
    List<Ecole> EcoNom(){
        return ecoleService.listNomEcol();
    }


    @DeleteMapping("/suppEcol/{id}")
    String suppInsc(@PathVariable("id") Long id){
       ecoleService.deleteecole(id);
        return "Ecole supprimer avec succès";
    }
}
