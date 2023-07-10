package com.example.Exagest.controller;

import com.example.Exagest.Service.NoteService;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Note;
import org.aspectj.weaver.ast.Not;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Note")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @PostMapping("/creeNote")
    Note ajouterNot(@RequestBody Note note){
        return noteService.addnote(note);
    }


    @PutMapping("/editNote/{id}")
    Note modifNot(@PathVariable("id") Long id, @RequestBody Note note){
        return noteService.editnote(id,note);
    }

    @GetMapping("/getAllNotSess")
    List<Note> NotSess(){
        return noteService.listSess();
    }

    @GetMapping("/getAllNotAttMat")
    List<Note> NotAttrMat(){
        return noteService.listAttriuMat();
    }


    @GetMapping("/getAllNotInsc")
    List<Note> NotInsc(){
        return noteService.listInsc();
    }

    @GetMapping("/getAllNoGen")
    List<Note> listeNotElePerAnnSessExam(@RequestParam("anneeID") String anneeID, @RequestParam String sessionID, @RequestParam String examID){
        return noteService.listeNotElePerAnnSessExam(anneeID, sessionID, examID);
    }

    @GetMapping("/getNotePerExam/{idExamen}/{idSession}")
    List<Note> genNotPerExam(@PathVariable("idExamen") Long idExamen,@PathVariable("idSession") Long idSession){
        return noteService.genererNoteParDefaut(idExamen,idSession);
    }





    @DeleteMapping("/suppNot/{id}")
    String suppNot(@PathVariable("id") Long id){
        noteService.deletenote(id);
        return "Note supprimer avec succès";
    }
}
