package com.example.Exagest.controller;

import com.example.Exagest.Service.EcoleService;
import com.example.Exagest.entities.Ecole;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Note;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/Ecole")
@RestController
public class EcoleController {
    private final EcoleService ecoleService;

    public EcoleController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    @PostMapping("/creeEcole")
    public ResponseEntity<Ecole> creeEcole(@RequestBody Ecole ecole ) {
//    Ecole ajouterEcol(@RequestBody Ecole ecole){
//        return ecoleService.addecole(ecole);
//    }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(ecoleService.addecole(ecole));
        } catch (Exception e) {
            System.out.println(" erreur  lors de la creation " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }





    @PutMapping("/editecole/{id}")
//    Ecole modifEcol(@PathVariable("id") Long id, @RequestBody Ecole ecole){
//        return ecoleService.editecole(id,ecole);
//    }
    public ResponseEntity<Ecole> modifierEcol(@RequestBody Ecole ecole, @PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ecoleService.editecole(id,ecole));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }





    @GetMapping("/getAllEcolCycle")
//    List<Ecole> EcoCyc(){
//        return ecoleService.listEcolCycle();
//    }
    public ResponseEntity<List<Ecole>>  toutesLesEcolesPerCyc(){
        return ResponseEntity.status(HttpStatus.OK).body(ecoleService.listEcolCycle());
    }










    @DeleteMapping("/suppEcol/{id}")
//    String suppInsc(@PathVariable("id") Long id){
//       ecoleService.deleteecole(id);
//        return "Ecole supprimer avec succès";
//    }
//}
    public ResponseEntity<String> supprimerEcole(@PathVariable("id") Long id) {
        try {
            ecoleService.deleteecole(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Ecole supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
