package com.example.Exagest.controller;

import com.example.Exagest.Service.MatiereService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Eleve;
import com.example.Exagest.entities.Matiere;
import com.example.Exagest.entities.Note;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/Matiere")
public class MatiereController {
  private final MatiereService matiereService;


    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    @PostMapping("/creeMatiere")
    public ResponseEntity<Matiere> creeMat(@RequestBody Matiere matiere ) {

//        Matiere ajouterMat(@RequestBody Matiere matiere){
//        return matiereService.addmatiere(matiere);
//    }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(matiereService.addmatiere(matiere));
        } catch (Exception e) {
            System.out.println(" erreur  lors de la creation " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }









    @PutMapping("/editMatiere/{id}")
//    Matiere modifInsc(@PathVariable("id") Long id, @RequestBody Matiere matiere){
//
//        return matiereService.editmatiere(id,matiere);
//    }
    public ResponseEntity<Matiere> modifInsc(@PathVariable("id") Long id, @RequestBody Matiere matiere) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(matiereService.editmatiere(id,matiere));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    @GetMapping("/getUneMat/{id}")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<Matiere>  uneMat(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(matiereService.findByIdOfMat(id));
    }










    @GetMapping("/getMatPerElev")
//    HashMap<String, List<Eleve>> matPerElv(){
//        return matiereService.matPerElv();
//    }

    public ResponseEntity< HashMap<String, List<Eleve>>>   matPerElv(){
        return ResponseEntity.status(HttpStatus.OK).body(matiereService.matPerElv());
    }










    @DeleteMapping("/suppMat/{id}")
//    String suppInsc(@PathVariable("id") Long id){
//        matiereService.deleteMatiere(id);
//        return "Matiere supprimer avec succès";
//    }
//}
    public ResponseEntity<String> suppInsc(@PathVariable("id") Long id) {
        try {
            matiereService.deleteMatiere(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Matiere supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
