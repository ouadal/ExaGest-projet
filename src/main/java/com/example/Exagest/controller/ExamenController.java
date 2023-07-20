package com.example.Exagest.controller;

import com.example.Exagest.Service.ExamenService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Examen;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Note;
import com.example.Exagest.requests.EnrolementRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Examen")
public class ExamenController {
    private final ExamenService examenService;

    public ExamenController(ExamenService examenService) {
        this.examenService = examenService;
    }

    @PostMapping("/creeExam")
    public ResponseEntity<Examen> creeExam(@RequestBody EnrolementRequestModel enrolementRequestModel ) {


//    Examen ajouterInsc(@RequestBody Examen examen){
//        return examenService.addexamen(examen);
//    }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body( examenService.addexamen(enrolementRequestModel));
        } catch (Exception e) {
            System.out.println(" erreur  lors de la creation " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }






    @PutMapping("/editexam/{id}")
//    Examen modifexam(@PathVariable("id") Long id, @RequestBody Examen examen){
//
//        return examenService.editexamen(id,examen);
//    }
    public ResponseEntity<Examen> modifierExam(@PathVariable("id") Long id, @RequestBody Examen examen) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(examenService.editexamen(id,examen));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }





    @GetMapping("/getAllExamEcol")
//    List<Examen> ExamEco(){
//        return examenService.listEcol();
//    }



    public ResponseEntity<List<Examen>>  toutesLesNExam(){
        return ResponseEntity.status(HttpStatus.OK).body(examenService.listEcol());
    }













    @GetMapping("/getUnExam/{id}")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<Examen>  unExam(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(examenService.findByIdOfExam(id));
    }






    @DeleteMapping("/suppExam/{id}")
//    String suppExam(@PathVariable("id") Long id){
//        examenService.deleteexamen(id);
//        return "Examen supprimer avec succès";
//    }
//}


    public ResponseEntity<String> supprimerExam(@PathVariable("id") Long id) {
        try {
            examenService.deleteexamen(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Examen supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
