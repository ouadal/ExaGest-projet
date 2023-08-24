package com.example.Exagest.controller;

import com.example.Exagest.Service.EleveService;
import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Eleve;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Note;
import com.example.Exagest.requests.InscriptionRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Eleve")
@CrossOrigin("*")
public class EleveController {
    private final EleveService eleveService;


    public EleveController(EleveService eleveService) {
        this.eleveService = eleveService;
    }

    @PostMapping("/creeEleve")
    public ResponseEntity<Eleve> ajouterInsc(@RequestBody InscriptionRequestModel inscriptionRM) {

//    Eleve ajouterInsc(@RequestBody InscriptionRequestModel inscriptionRM){
//        return eleveService.addeleve(inscriptionRM);
//    }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(eleveService.addeleve(inscriptionRM));
        } catch (Exception e) {
            System.out.println(" erreur  lors de la creation " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }








    @PutMapping("/editEleve/{id}")
//    Eleve modifElev(@PathVariable("id") Long id, @RequestBody Eleve eleve){
//        return eleveService.editeleve(id,eleve);
//    }

    public ResponseEntity<Eleve> modifElev(@PathVariable("id") Long id, @RequestBody Eleve eleve) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(eleveService.editeleve(id,eleve));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    @GetMapping("/getAllElevPerSex")
    public ResponseEntity<List<Eleve>>  listElevPersex(@RequestParam String sexe){
        return ResponseEntity.status(HttpStatus.OK).body(eleveService.listElevePerSex(sexe));
    }




    @GetMapping("/getAllElev")
    public ResponseEntity<List<Eleve>>  tousElev(){
        return ResponseEntity.status(HttpStatus.OK).body(eleveService.listNom());
    }

    @GetMapping("/getAllElevByEcol/{idEcole}")
    public ResponseEntity<List<Eleve>>  getAllElevByEcol(@PathVariable Long idEcole){
        return ResponseEntity.status(HttpStatus.OK).body(eleveService.getAllElevByEcol(idEcole));
    }







    @GetMapping("/getAllElevMat")
//    List<Eleve> tousElevMat(@RequestParam("id") Long id){
//        return eleveService.listElevMat(id);
//    }
    public ResponseEntity<List<Eleve>>  tousElevMat(@RequestParam("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(eleveService.listElevMat(id));
    }





    @GetMapping("/getUnElev/{id}")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<Eleve>  unElev(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(eleveService.findByIdOfElev(id));
    }








    @DeleteMapping("/suppElev/{id}")
//    String suppElev(@PathVariable("id") Long id){
//        eleveService.deleteeleve(id);
//        return "Inscription supprimer avec succès";
//    }
//}

    public ResponseEntity<String> supprimerElev(@PathVariable("id") Long id) {
        try {
            eleveService.deleteeleve(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eleve supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
