package com.example.Exagest.controller;

import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.Service.TypeExamenService;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Note;
import com.example.Exagest.entities.TypeExamen;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TypeExamen> creeTypExam(@RequestBody TypeExamen typeExamen ) {

//    TypeExamen ajouterTypeExam(@RequestBody TypeExamen typeExamen){
//        return typeExamenService.addtypeExamen(typeExamen);
//    }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(typeExamenService.addtypeExamen(typeExamen));
        } catch (Exception e) {
            System.out.println(" erreur  lors de la creation " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }







    @PutMapping("/editTypeExam/{id}")
//    TypeExamen modifTypeExam(@PathVariable("id") Long id, @RequestBody TypeExamen typeExamen){
//        return typeExamenService.edittypeExamen(id,typeExamen);
//    }
    public ResponseEntity<TypeExamen> modifTypeExam(@PathVariable("id") Long id, @RequestBody TypeExamen typeExamen) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(typeExamenService.edittypeExamen(id,typeExamen));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }










    @GetMapping("/getAllInscrEcol")
//    List<TypeExamen> tousEco(){
//        return typeExamenService.listtypeExamLib();
//    }
    public ResponseEntity<List<TypeExamen>>  tousEco(){
        return ResponseEntity.status(HttpStatus.OK).body(typeExamenService.listtypeExamLib());
    }










    @DeleteMapping("/suppTypeExam/{id}")
//    String suppTypeExam(@PathVariable("id") Long id){
//        typeExamenService.deletetypeExamen(id);
//        return "TypeExamen  supprimer avec succès";
//    }
//}
    public ResponseEntity<String> supprimerTypMat(@PathVariable("id") Long id) {
        try {
            typeExamenService.deletetypeExamen(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Type exam supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
