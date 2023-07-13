package com.example.Exagest.controller;

import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.Service.TypeMatService;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Note;
import com.example.Exagest.entities.TypeMat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TypeMat> creeTypMat(@RequestBody TypeMat typeMat ) {

//    TypeMat ajouterTypMat(@RequestBody TypeMat typeMat){
//        return typeMatService.addtypeMat(typeMat);
//    }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(typeMatService.addtypeMat(typeMat));
        } catch (Exception e) {
            System.out.println(" erreur  lors de la creation " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }






    @PutMapping("/editTypeMat/{id}")
//    TypeMat modifTypMat(@PathVariable("id") Long id, @RequestBody TypeMat typeMat){
//        return typeMatService.edittypeMat(id,typeMat);
//    }
    public ResponseEntity<TypeMat> modifierTypMat(@PathVariable("id") Long id, @RequestBody TypeMat typeMat) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(typeMatService.edittypeMat(id,typeMat));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }










    @GetMapping("/getAllTypeMat")
//    List<TypeMat> typMot(){
//        return typeMatService.listtypeMatLib();
//    }

    public ResponseEntity<List<TypeMat>>  toutesLesTypMat(){
        return ResponseEntity.status(HttpStatus.OK).body(typeMatService.listtypeMatLib());
    }









    @DeleteMapping("/suppTyp/{id}")
//    String suppTypeMat(@PathVariable("id") Long id){
//        typeMatService.deletetypeMat(id);
//        return "Type Matiere supprimer avec succès";
//    }
//
//}
    public ResponseEntity<String> supprTypMat(@PathVariable("id") Long id) {
        try {
            typeMatService.deletetypeMat(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Type Mat supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
