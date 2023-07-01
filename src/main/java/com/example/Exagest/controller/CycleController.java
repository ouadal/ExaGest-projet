package com.example.Exagest.controller;

import com.example.Exagest.Service.CycleService;
import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.Cycle;
import com.example.Exagest.entities.Inscription;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Cycle")
public class CycleController {
    private final CycleService cycleService;

    public CycleController(CycleService cycleService) {
        this.cycleService = cycleService;
    }

    @PostMapping("/creeCycle")
    Cycle ajoutercyc(@RequestBody Cycle cycle){
        return cycleService.addcycle(cycle);
    }

    @PutMapping("/editcycle/{id}")
    Cycle modifInsc(@PathVariable("id") Long id, @RequestBody Cycle cycle){
        return cycleService.editcycle(id,cycle);
    }


    @GetMapping("/getAllCycle")
    List<Cycle> tousCycle(){
        return cycleService.listcycle();
    }


    @DeleteMapping("/suppInsc/{id}")
    String suppcycle(@PathVariable("id") Long id){
                   cycleService.deletecycle(id);
        return " Cycle supprimer avec succès";
    }
}
