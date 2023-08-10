package com.example.Exagest.controller;

import com.example.Exagest.Service.MoyenneService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Moyenne;
import com.example.Exagest.entities.Note;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Moyenne")
@CrossOrigin("*")
public class MoyenneController {
    private final MoyenneService moyenneService;

    public MoyenneController(MoyenneService moyenneService) {
        this.moyenneService = moyenneService;
    }


    @PostMapping("/creeMoyen")
    public ResponseEntity<Moyenne> creeMat(@RequestBody Moyenne moyenne ) {

//    Moyenne ajouterMoyen(@RequestBody Moyenne moyenne){
//        return moyenneService.addmoyenne(moyenne);
//    }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(moyenneService.addmoyenne(moyenne));
        } catch (Exception e) {
            System.out.println(" erreur  lors de la creation " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }










    @PutMapping("/editMoyen/{id}")
//    Moyenne modifInsc(@PathVariable("id") Long id, @RequestBody Moyenne moyenne){
//        return moyenneService.editmoyenne(id,moyenne);
//    }
    public ResponseEntity<Moyenne> modifieMoyennet(@PathVariable("id") Long id, @RequestBody Moyenne moyenne) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(moyenneService.editmoyenne(id,moyenne));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }











    @GetMapping("/getAllMoySess")
//    List<Moyenne> MoySess(){
//        return moyenneService.listSess();
//    }
    public ResponseEntity<List<Moyenne>>  MoySess(){
        return ResponseEntity.status(HttpStatus.OK).body(moyenneService.listSess());
    }




    @GetMapping("/getMoyForAllEcolRang")


    public ResponseEntity<List<Moyenne>> moyenAllForEcolRangee(@RequestParam("idExamen") Long idExamen, @RequestParam Long idsession){
        return ResponseEntity.status(HttpStatus.OK).body(moyenneService.moyennePerExamLorsSessforAllEcol(idExamen, idsession));
    }





    @GetMapping("/getMoyForUneEcolRang")


    public ResponseEntity<List<Moyenne>> moyenUneForEcolRangee(@RequestParam("idExamen") Long idExamen, @RequestParam Long idsession ,@RequestParam Long idEcole ){
        return ResponseEntity.status(HttpStatus.OK).body(moyenneService.moyennePerExamLorsSessforUneEcol(idExamen, idsession,idEcole));
    }





    @GetMapping("/getUneMoy/{id}")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<Moyenne>  uneMoy(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(moyenneService.findByIdOfMoy(id));
    }





    @GetMapping("/genererMoyenne")


    public void moyenUneForEcolRangee(@RequestParam("idExamen") Long idExamen, @RequestParam Long idsession  ){
        moyenneService.genererMoyenne(idExamen, idsession);
    }








    @GetMapping("/calculerMoyenne")
//    List<Note> listNotElevPerExamSession(@RequestParam("idExamen") Long idExamen, @RequestParam Long idInscription, @RequestParam Long idSession){
//        return noteService.listNoteElevPerExamenSession(idExamen,idInscription,idSession);
//    }
    public ResponseEntity<String> calculemoyenne(@RequestParam("idExamen") Long idExamen, @RequestParam Long idInscription, @RequestParam Long idSession) {
        try {
            moyenneService.calculerMoyenne(idExamen,  idInscription, idSession);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("moyenne calculé avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }











    @DeleteMapping("/suppMoy/{id}")
//    String suppInsc(@PathVariable("id") Long id){
//        moyenneService.deletemoyenne(id);
//        return "Moyenne supprimer avec succès";
//    }
//}
    public ResponseEntity<String> supprimerNote(@PathVariable("id") Long id) {
        try {
            moyenneService.deletemoyenne(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Moyenne supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
