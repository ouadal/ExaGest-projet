package com.example.Exagest.controller;

import com.example.Exagest.Service.AttributionMatiereService;
import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Note;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/AttributionMat")
@CrossOrigin("*")
public class AttributionMatiereController {
    private final AttributionMatiereService attributionMatiereService;

    public AttributionMatiereController(AttributionMatiereService attributionMatiereService) {
        this.attributionMatiereService = attributionMatiereService;
    }

    @PostMapping("/creeAttribution")
    public ResponseEntity<AttributionMatiere> creeAttriMat(@RequestBody AttributionMatiere attributionMatiere ) {

//    AttributionMatiere ajouterAttr(@RequestBody AttributionMatiere attributionMatiere){
//        return attributionMatiereService.addattMat(attributionMatiere);
//    }
        try {
        return ResponseEntity.status(HttpStatus.CREATED).body(attributionMatiereService.addattMat(attributionMatiere));
    } catch (Exception e) {
        System.out.println(" erreur  lors de la creation " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}





    @PutMapping("/editAttribu/{id}")
//    AttributionMatiere modifAttr(@PathVariable("id") Long id, @RequestBody AttributionMatiere attributionMatiere){
//        return attributionMatiereService.editattMat(id,attributionMatiere);
//    }
    public ResponseEntity<AttributionMatiere> modifierAttMat(@RequestBody AttributionMatiere attributionMatiere, @PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(attributionMatiereService.editattMat(id,attributionMatiere));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }




    @GetMapping("/getAllAttriMatAnn")
//    List<AttributionMatiere> attrmat(){
//        return attributionMatiereService.listattributionMatAnne();
//    }
    public ResponseEntity<List<AttributionMatiere>>  toutesLesAttribuMatperAnn(){
        return ResponseEntity.status(HttpStatus.OK).body(attributionMatiereService.listattributionMatAnne());
    }



    @GetMapping("/getAllAttPerExam/{id}")
//    List<AttributionMatiere> attrMatPerEx( @PathVariable("id") Long idEx){
//        return attributionMatiereService.listattributionMatExam(idEx);
//    }
    public ResponseEntity<List<AttributionMatiere>>  toutesLesAttriMatPerExam( @PathVariable("id") Long idEx){
        return ResponseEntity.status(HttpStatus.OK).body(attributionMatiereService.listattributionMatExam(idEx));
    }







    @GetMapping("/getUneAttMat/{id}")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<AttributionMatiere>  uneAttMat(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(attributionMatiereService.findByIdOfAttMat(id));
    }





    @GetMapping("/getAttMatByEcolConn/{idEcol}")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<List<AttributionMatiere>>  attMatByEcolConn(@PathVariable("idEcol") Long idEcol){
        return ResponseEntity.status(HttpStatus.OK).body(attributionMatiereService.getAttMatByEcolConn(idEcol));
    }







    @DeleteMapping("/suppAttri/{id}")
//    String suppInsc(@PathVariable("id") Long id){
//        attributionMatiereService.deletattMat(id);
//        return "Attribution matiere supprimer avec succès";
//    }
//}

    public ResponseEntity<String> supprimerAttribuMat(@PathVariable("id") Long id) {
        try {
            attributionMatiereService.deletattMat(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Attribution matière supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
