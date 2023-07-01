package com.example.Exagest.controller;

import com.example.Exagest.Service.ExamenService;
import com.example.Exagest.entities.Examen;
import com.example.Exagest.entities.Inscription;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Examen")
public class ExamenController {
    private final ExamenService examenService;

    public ExamenController(ExamenService examenService) {
        this.examenService = examenService;
    }

    @PostMapping("/creeInscription")
    Examen ajouterInsc(@RequestBody Examen examen){
        return examenService.addexamen(examen);
    }

    @PutMapping("/editexam/{id}")
    Examen modifexam(@PathVariable("id") Long id, @RequestBody Examen examen){

        return examenService.editexamen(id,examen);
    }

    @GetMapping("/getAllExamEcol")
    List<Examen> ExamEco(@RequestBody Examen examen){
        return examenService.listEcol();
    }

    @GetMapping("/getAllExamAnn")
    List<Examen> ExamAnn(@RequestBody Examen examen){
        return examenService.listAnnee();
    }


    @GetMapping("/getAllExamLib")
    List<Examen> ExamLib(@RequestBody Examen examen){
        return examenService.listExameLib();
    }



    @DeleteMapping("/suppExam/{id}")
    String suppExam(@PathVariable("id") Long id){
        examenService.deleteexamen(id);
        return "Examen supprimer avec succès";
    }
}
