package com.example.Exagest.controller;

import com.example.Exagest.Service.CycleService;
import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Cycle;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Note;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Cycle")
@CrossOrigin("*")
public class CycleController {
    private final CycleService cycleService;

    public CycleController(CycleService cycleService) {
        this.cycleService = cycleService;
    }

    @PostMapping("/creeCycle")
    public ResponseEntity<Cycle> creeCycle(@RequestBody Cycle cycle ) {
    //Cycle ajoutercyc(@RequestBody Cycle cycle){
//        return cycleService.addcycle(cycle);
//    }

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(cycleService.addcycle(cycle));
        } catch (Exception e) {
            System.out.println(" erreur  lors de la creation " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }






    @PutMapping("/editcycle/{id}")
//    Cycle modifInsc(@PathVariable("id") Long id, @RequestBody Cycle cycle){
//        return cycleService.editcycle(id,cycle);
//    }
    public ResponseEntity<Cycle> modifierCycle(@RequestBody Cycle cycle, @PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cycleService.editcycle(id,cycle));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    @GetMapping("/getAllCycle")
//    List<Cycle> tousCycle(){
//        return cycleService.listcycle();
//    }
    public ResponseEntity<List<Cycle>>  toutesLesCycles(){
        return ResponseEntity.status(HttpStatus.OK).body(cycleService.listcycle());
    }



    @GetMapping("/getUnCycle/{id}")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<Cycle>  unCycle(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cycleService.findByIdOfCycle(id));
    }


    @DeleteMapping("/suppInsc/{id}")
//    String suppcycle(@PathVariable("id") Long id){
//                   cycleService.deletecycle(id);
//        return " Cycle supprimer avec succès";
//    }
    //}

    public ResponseEntity<String> supprimerCycle(@PathVariable("id") Long id) {
        try {
            cycleService.deletecycle(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cycle supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

