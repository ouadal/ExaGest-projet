package com.example.Exagest.controller;

import com.example.Exagest.Service.CycleTypeExamenService;
import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/CycleType")
public class CycleTypeExamenController {
    private final CycleTypeExamenService cycleTypeExamenService;

    public CycleTypeExamenController(CycleTypeExamenService cycleTypeExamenService) {
        this.cycleTypeExamenService = cycleTypeExamenService;
    }


    @PostMapping("/creeCycle")
//    CycleTypeExamen ajouterCyc(@RequestBody CycleTypeExamen cycleTypeExamen){
//        return cycleTypeExamenService.addcycleTypeExam(cycleTypeExamen);
//    }
    public ResponseEntity<CycleTypeExamen> creeCycTypExa(@RequestBody CycleTypeExamen cycleTypeExamen) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(cycleTypeExamenService.addcycleTypeExam(cycleTypeExamen));
        } catch (Exception e) {
            System.out.println(" erreur  lors de la creation " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }








    @PutMapping("/editInscription/{id}")
//    CycleTypeExamen modifInsc(@PathVariable("id") Long id, @RequestBody CycleTypeExamen cycleTypeExamen){
//        return cycleTypeExamenService.editcycleTypeExam(id,cycleTypeExamen);
//    }
    public ResponseEntity<CycleTypeExamen> modifierCycTypExa(@RequestBody CycleTypeExamen cycleTypeExamen, @PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cycleTypeExamenService.editcycleTypeExam(id,cycleTypeExamen));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }








    @GetMapping("/getAllCycle")
//    List<CycleTypeExamen> tousEco(){
//        return cycleTypeExamenService.listcycleTypeExam();
//    }
    public ResponseEntity<List<CycleTypeExamen>>  toutesLesCycTypExa(){
        return ResponseEntity.status(HttpStatus.OK).body(cycleTypeExamenService.listcycleTypeExam());
    }









    @GetMapping("/getUnCycleTyp/{id}")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<CycleTypeExamen>  uneCycTyp(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cycleTypeExamenService.findByIdOfCycTyp(id));
    }




    @DeleteMapping("/suppCycleType/{id}")
//    String suppcycle(@PathVariable("id") Long id){
//        cycleTypeExamenService.deletecycleTypeExam(id);
//        return "Cycle type examen supprimer avec succès";
//    }
    public ResponseEntity<String> supprimerCycTypEx(@PathVariable("id") Long id) {
        try {
            cycleTypeExamenService.deletecycleTypeExam(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cycle type exam supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
