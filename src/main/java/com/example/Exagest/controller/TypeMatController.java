package com.example.Exagest.controller;

import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.Service.TypeMatService;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.TypeMat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/TypeMat")
public class TypeMatController {

    private final TypeMatService typeMatService;


    public TypeMatController(TypeMatService typeMatService) {
        this.typeMatService = typeMatService;
    }

    @PostMapping("/creeTypeMat")
    TypeMat ajouterTypMat(@RequestBody TypeMat typeMat){
        return typeMatService.addtypeMat(typeMat);
    }
    @PutMapping("/editTypeMat/{id}")
    TypeMat modifTypMat(@PathVariable("id") Long id, @RequestBody TypeMat typeMat){
        return typeMatService.edittypeMat(id,typeMat);
    }

    @GetMapping("/getAllTypeMat")
    List<TypeMat> typMot(){
        return typeMatService.listtypeMatLib();
    }


    @DeleteMapping("/suppTyp/{id}")
    String suppTypeMat(@PathVariable("id") Long id){
        typeMatService.deletetypeMat(id);
        return "Type Matiere supprimer avec succès";
    }

}
