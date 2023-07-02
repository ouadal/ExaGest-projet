package com.example.Exagest.controller;

import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.Service.TypeExamenService;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.TypeExamen;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/TypeExamen")
public class TypeExamenController {
    private final TypeExamenService typeExamenService;



    public TypeExamenController(TypeExamenService typeExamenService) {
        this.typeExamenService = typeExamenService;
    }

    @PostMapping("/creeTypeExam")
    TypeExamen ajouterTypeExam(@RequestBody TypeExamen typeExamen){
        return typeExamenService.addtypeExamen(typeExamen);
    }

    @PutMapping("/editTypeExam/{id}")
    TypeExamen modifTypeExam(@PathVariable("id") Long id, @RequestBody TypeExamen typeExamen){
        return typeExamenService.edittypeExamen(id,typeExamen);
    }

    @GetMapping("/getAllInscrEcol")
    List<TypeExamen> tousEco(){
        return typeExamenService.listtypeExamLib();
    }



    @DeleteMapping("/suppTypeExam/{id}")
    String suppTypeExam(@PathVariable("id") Long id){
        typeExamenService.deletetypeExamen(id);
        return "TypeExamen  supprimer avec succès";
    }
}
