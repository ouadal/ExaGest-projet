package com.example.Exagest.controller;

import com.example.Exagest.Service.AnneeService;
import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Note;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/Annee")
@CrossOrigin("*")
public class AnneeController {
    private final AnneeService anneeService;

    public AnneeController(AnneeService anneeService) {
        this.anneeService = anneeService;
    }

    @PostMapping("/creeAnnee")
    public ResponseEntity<Annee> creeAnnee(@RequestBody Annee annee ) {
  //Annee ajouterann(@RequestBody Annee annee){
//        return anneeService.addAnnee(annee);
//    }
        try {
        return ResponseEntity.status(HttpStatus.CREATED).body(anneeService.addAnnee(annee));
    } catch (Exception e) {
        System.out.println(" erreur  lors de la creation " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}


    @GetMapping("/getCurrentAnnee")
    public ResponseEntity<Annee>  currentAnnee(){
        return ResponseEntity.status(HttpStatus.OK).body(anneeService.getCurrentYear());
    }



    @PutMapping("/editAnnee/{id}")
//    Annee modifann(@PathVariable("id") Long id, @RequestBody Annee annee){
//        return anneeService.editAnnee(id,annee);
//    }
    public ResponseEntity<Annee> modifierAnne(@RequestBody Annee annee, @PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(anneeService.editAnnee(id,annee));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }






    @GetMapping("/getAllAnn")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<List<Annee>>  touteslesAnnee(){
        return ResponseEntity.status(HttpStatus.OK).body(anneeService.listAnne());
    }



    @GetMapping("/getUneAnnee/{id}")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<Annee>  uneAnnne(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(anneeService.findByIdOfAYear(id));
    }



    @PutMapping ("/AnneeEnCours/{id}")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<Annee>  AnneeEncours(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(anneeService.setCurrentYear( id));
    }





    @DeleteMapping("/suppAnn/{id}")
//    String suppAnn(@PathVariable("id") Long id){
//        anneeService.deleteAnnee(id);
//        return "Annee supprimer avec succès";
//    }

    public ResponseEntity<String> supprimerAnnne(@PathVariable("id") Long id) {
        try {
            anneeService.deleteAnnee(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Annee supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
