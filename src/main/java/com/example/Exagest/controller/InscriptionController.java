package com.example.Exagest.controller;

import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Note;
import com.example.Exagest.requests.InscriptionRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/Inscription")
@CrossOrigin("*")
public class InscriptionController {

    private final InscriptionService inscriptionService;

    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @PostMapping("/creeInscription")
    public ResponseEntity<Inscription> ajouterInsc(@RequestBody InscriptionRequestModel inscriptionRM) {
//    Inscription ajouterInsc(@RequestBody InscriptionRequestModel inscriptionRM){
//        return inscriptionService.addinscription(inscriptionRM);
//    }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(inscriptionService.addinscription(inscriptionRM));
        } catch (Exception e) {
            System.out.println(" erreur  lors de la creation " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }







    @PutMapping("/editInscription/{id}")
//    Inscription modifInsc(@PathVariable("id") Long id, @RequestBody Inscription inscription){
//        return inscriptionService.editinscriptionn(id,inscription);
//    }
    public ResponseEntity<Inscription> modifInsc(@PathVariable("id") Long id, @RequestBody Inscription inscription) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(inscriptionService.editinscriptionn(id,inscription));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }









    @GetMapping("/getAllInscrPerExam/{id}")
//    List<Inscription> InscPerEx(@PathVariable("id") Long id){
//        return inscriptionService.listInscPerExam(id);
//    }

    public ResponseEntity< List<Inscription>> InscPerEx(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(inscriptionService.listInscPerExam(id));


    }


    @GetMapping("/getAllInscrPerElev")
//    List<Inscription> InscPerEx(@PathVariable("id") Long id){
//        return inscriptionService.listInscPerExam(id);
//    }

    public ResponseEntity< List<Inscription>> AllInscPerEle() {
        return ResponseEntity.status(HttpStatus.OK).body(inscriptionService.listElev());
    }

    @GetMapping("/listInscPerEcolAndExam")
    public ResponseEntity< List<Inscription>> listInscPerEcolAndExam(@RequestParam Long idEcole,@RequestParam Long idExamen) {
        return ResponseEntity.status(HttpStatus.OK).body(inscriptionService.listInscPerEcolAndExam(idEcole,idExamen));
    }











    @GetMapping("/listInscDesElevPerExam")
    public ResponseEntity< List<Inscription>> listInscDesElevPerExam(@RequestParam Long idElev,@RequestParam Long idExamen) {
        return ResponseEntity.status(HttpStatus.OK).body(inscriptionService.listInscDesElevPerExam(idElev,idExamen));
    }










    @GetMapping("/getUneInsc/{id}")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<Inscription>  unInsc(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(inscriptionService.findByIdOfInsc(id));
    }







    @DeleteMapping("/suppInsc/{id}")
//    String suppInsc(@PathVariable("id") Long id){
//        inscriptionService.deleteinscription(id);
//        return "Inscription supprimer avec succès";
//    }
//}

    public ResponseEntity<String> supprimerInsc(@PathVariable("id") Long id) {
        try {
            inscriptionService.deleteinscription(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Inscription supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
