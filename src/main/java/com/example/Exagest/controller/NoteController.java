package com.example.Exagest.controller;

import com.example.Exagest.Service.NoteService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Note;
import com.example.Exagest.requests.NoteUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Note")
@CrossOrigin("*")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @PostMapping("/creeNote")
    public ResponseEntity<Note> creeNote(@RequestBody Note note ) {
//        Note add(@RequestBody Annee annee){
//            return anneeService.addAnnee(annee);
//        }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(noteService.addnote(note));
        } catch (Exception e) {
            System.out.println(" erreur  lors de la creation " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }





    @PutMapping("/editNote/{id}")
//    Note modifNot(@PathVariable("id") Long id, @RequestBody Note note){
//        return noteService.editnote(id,note);
//    }
    public ResponseEntity<Note> modifierNot(@RequestBody Note note, @PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(noteService.editnote(note, id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }







    @GetMapping("/getAllNotSess")
//    List<Note> NotSess(){
//        return noteService.listSess();
//    }
    public ResponseEntity<List<Note>>  toutesLesNotesParSession(){
        return ResponseEntity.status(HttpStatus.OK).body(noteService.listSess());
    }






    @GetMapping("/listDesElevPerExamenSessionInscription")
//    List<Note> NotSess(){
//        return noteService.listSess();
//    }
    public ResponseEntity<List<Note>>  listDesElevPerExamenSessionInscription(@RequestParam("idExamen") Long idExamen, @RequestParam Long idEcol, @RequestParam Long idSession){
        return ResponseEntity.status(HttpStatus.OK).body(noteService.listDesElevPerExamenSessionInscription(idExamen,idEcol,idSession));
    }





    @GetMapping("/findNotePerExamAttribSess")
//    List<Note> NotSess(){
//        return noteService.listSess();
//    }
    public ResponseEntity<List<Note>>  findNotePerExamAttribSess(@RequestParam("idExamen") Long idExamen, @RequestParam Long idAttrMat, @RequestParam Long idSession){
        return ResponseEntity.status(HttpStatus.OK).body(noteService.findNotePerExamAttribSess(idExamen,idAttrMat,idSession));
    }









    @GetMapping("/getAllNotAttMat")
//    List<Note> NotAttrMat(){
//        return noteService.listAttriuMat();
//    }
    public ResponseEntity<List<Note>>  toutesLesNotesParAttriMat(){
        return ResponseEntity.status(HttpStatus.OK).body(noteService.listAttriuMat());
    }





    @GetMapping("/getAllNotInsc")
//    List<Note> NotInsc(){
//        return noteService.listInsc();
//    }
    public ResponseEntity<List<Note>>  toutesLesNotesParInscription(){
        return ResponseEntity.status(HttpStatus.OK).body(noteService.listInsc());
    }






    @GetMapping("/getAllNoGen")
//    List<Note> listeNotElePerAnnSessExam(@RequestParam("anneeID") String anneeID, @RequestParam String sessionID, @RequestParam String examID){
//        return noteService.listeNotElePerAnnSessExam(anneeID, sessionID, examID);
//    }
    public ResponseEntity<List<Note>> listeNotElePerAnnSessExam(@RequestParam("anneeID") String anneeID, @RequestParam String sessionID, @RequestParam String examID){
        return ResponseEntity.status(HttpStatus.OK).body(noteService.listeNotElePerAnnSessExam(anneeID, sessionID, examID));
    }






    @GetMapping("/getNotePerExam/{idExamen}/{idSession}")
//    List<Note> genNotPerExam(@PathVariable("idExamen") Long idExamen,@PathVariable("idSession") Long idSession){
//        return noteService.genererNoteParDefaut(idExamen,idSession);
//    }
    public ResponseEntity<List<Note>>  genererNotePerExamen(@PathVariable("idExamen") Long idExamen,@PathVariable("idSession") Long idSession){
        return ResponseEntity.status(HttpStatus.OK).body(noteService.genererNoteParDefaut(idExamen,idSession));
    }







    @GetMapping("/getNotElevPerExamSession")
//    List<Note> listNotElevPerExamSession(@RequestParam("idExamen") Long idExamen, @RequestParam Long idInscription, @RequestParam Long idSession){
//        return noteService.listNoteElevPerExamenSession(idExamen,idInscription,idSession);
//    }
    public ResponseEntity< List<Note>> notElevParExamSession(@RequestParam("idExamen") Long idExamen, @RequestParam Long idInscription, @RequestParam Long idSession) {
            return ResponseEntity.status(HttpStatus.OK).body(noteService.listNoteElevPerExamenSession(idExamen,idInscription,idSession));


    }




    @GetMapping("/listNotePerExamSesion")
//    List<Note> listNotElevPerExamSession(@RequestParam("idExamen") Long idExamen, @RequestParam Long idInscription, @RequestParam Long idSession){
//        return noteService.listNoteElevPerExamenSession(idExamen,idInscription,idSession);
//    }
    public ResponseEntity< List<Note>> listNotePerExamSesion(@RequestParam("idExamen") Long idExamen, @RequestParam Long idSession) {
        return ResponseEntity.status(HttpStatus.OK).body(noteService.listNotePerExamSesion(idExamen,idSession));


    }
@GetMapping("/listNotePerExamSesionMat")
//    List<Note> listNotElevPerExamSession(@RequestParam("idExamen") Long idExamen, @RequestParam Long idInscription, @RequestParam Long idSession){
//        return noteService.listNoteElevPerExamenSession(idExamen,idInscription,idSession);
//    }
    public ResponseEntity< List<Note>> listNotePerExamSesionMat(@RequestParam Long idExamen, @RequestParam Long idSession,@RequestParam Long idMat) {
        return ResponseEntity.status(HttpStatus.OK).body(noteService.listNotePerExamSesionMat(idExamen,idSession,idMat));
    }








    @PutMapping("/miseAjourDeToutesLesNotes")
    public ResponseEntity<List<Note>> miseAjourNotes(@RequestBody List<NoteUpdate> listNotes) {
        List<Note> updatedNotes = noteService.mettreAjourLesNote(listNotes);
        return ResponseEntity.status(HttpStatus.OK).body(updatedNotes);
    }





    @GetMapping("/getUneNot/{id}")
//    List<Annee> tousEco(){
//        return anneeService.listAnne();
//    }
    public ResponseEntity<Note>  uneNot(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(noteService.findByIdOfNot(id));
    }




//    @GetMapping("/calculerMoyenne")
////    List<Note> listNotElevPerExamSession(@RequestParam("idExamen") Long idExamen, @RequestParam Long idInscription, @RequestParam Long idSession){
////        return noteService.listNoteElevPerExamenSession(idExamen,idInscription,idSession);
////    }
//    public ResponseEntity<String> calculemoyenne(@RequestParam("idExamen") Long idExamen, @RequestParam Long idInscription, @RequestParam Long idSession) {
//        try {
//            noteService.calculerMoyenne(idExamen,  idInscription, idSession);
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("moyenne calculé avec succès");
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }







    @DeleteMapping("/suppNot/{id}")
    public ResponseEntity<String> supprimerNote(@PathVariable("id") Long id) {
        try {
            noteService.deletenote(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Note supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
