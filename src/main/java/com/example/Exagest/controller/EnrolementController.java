package com.example.Exagest.controller;

import com.example.Exagest.Service.EnrolementService;
import com.example.Exagest.entities.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/Enrolement")
@RestController
@CrossOrigin("*")
public class EnrolementController {
    private final EnrolementService enrolementService;

    public EnrolementController(EnrolementService enrolementService) {
        this.enrolementService = enrolementService;
    }


    @PostMapping("/creeEnrolement")
    public ResponseEntity<Enrolement> creeEnrol(@RequestBody Enrolement enrolement ) {

    //Enrolement ajouterEnrol(@RequestBody Enrolement enrolement){
//        return enrolementService.addenrolement(enrolement);
//    }

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(enrolementService.addenrolement(enrolement));
        } catch (Exception e) {
            System.out.println(" erreur  lors de la creation " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }








    @PutMapping("/editenrol/{id}")
//    Enrolement modifEnrol(@PathVariable("id") Long id, @RequestBody Enrolement enrolement){
//        return enrolementService.editenrolement(id,enrolement);
//    }
    public ResponseEntity<Enrolement> modifierEnrol(@PathVariable("id") Long id, @RequestBody Enrolement enrolement) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(enrolementService.editenrolement(id,enrolement));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }







    @GetMapping("/getAllEnrolEcol")
    public ResponseEntity<List<Enrolement>>  toutesLesEnrol(){
        return ResponseEntity.status(HttpStatus.OK).body(enrolementService.listEcol());
    }
    

    @GetMapping("/getAllEnrollementsByEcol/{idEcole}")
    public ResponseEntity<List<Enrolement>>  getAllEnrollementsByEcol(@PathVariable Long idEcole){
        return ResponseEntity.status(HttpStatus.OK).body(enrolementService.getAllEnrollementsByEcol(idEcole));
    }
    @GetMapping("/getAllEcolThatAreEnrolled/{idExamen}")
    public ResponseEntity<List<Enrolement>>  getAllEcolThatAreEnrolled(@PathVariable Long idExamen){
        return ResponseEntity.status(HttpStatus.OK).body(enrolementService.getAllEcolThatAreEnrolled(idExamen));
    }



    @GetMapping("/getUnEnrol/{id}")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<Enrolement>  unEnrol(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(enrolementService.findByIdOfEnrol(id));
    }










    @DeleteMapping("/suppEnrol/{id}")
//    String suppEnrol(@PathVariable("id") Long id){
//        enrolementService.deleteenrolement(id);
//        return "enrolement supprimer avec succès";
//    }
//}

    public ResponseEntity<String> supprimerEnrol(@PathVariable("id") Long id) {
        try {
            enrolementService.deleteenrolement(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Enrolement supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
