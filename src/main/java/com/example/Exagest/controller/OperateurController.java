package com.example.Exagest.controller;

import com.example.Exagest.Service.OperateurService;
import com.example.Exagest.entities.Operateur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class OperateurController {

    private final OperateurService operateurService;

    public OperateurController(OperateurService operateurService) {
        this.operateurService = operateurService;
    }


    @PostMapping("/creeOp")
        public ResponseEntity<Operateur> creeNote(@RequestBody Operateur operateur) {
//        Note add(@RequestBody Annee annee){
//            return anneeService.addAnnee(annee);
//        }
            try {
                return ResponseEntity.status(HttpStatus.CREATED).body(operateurService.addop(operateur));
            } catch (Exception e) {
                System.out.println(" erreur  lors de la creation " + e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }





        @PutMapping("/editop/{id}")
//    Note modifNot(@PathVariable("id") Long id, @RequestBody Note note){
//        return noteService.editnote(id,note);
//    }
        public ResponseEntity<Operateur> modifierNot(@RequestBody Operateur operateur, @PathVariable("id") Long id) {
            try {
                return ResponseEntity.status(HttpStatus.OK).body(operateurService.editop(operateur, id));
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
















    @GetMapping("/getUnop/{id}")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<Operateur> getop(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(operateurService.findByIdOfOp(id));
    }








        @DeleteMapping("/suppOp/{id}")
        public ResponseEntity<String> supprimeop(@PathVariable("id") Long id) {
            try {
                operateurService.deleteop(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Note supprimée avec succès");
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
    }

