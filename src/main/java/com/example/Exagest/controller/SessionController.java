package com.example.Exagest.controller;

import com.example.Exagest.Service.SessionService;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Note;
import com.example.Exagest.entities.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Session")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }


    @PostMapping("/creeSession")
    public ResponseEntity<Session> creeSess(@RequestBody Session session ) {

//    Session ajouterSess(@RequestBody Session session){
////        return sessionService.addsession(session);
////    }

        try {
        return ResponseEntity.status(HttpStatus.CREATED).body(sessionService.addsession(session));
    } catch (Exception e) {
        System.out.println(" erreur  lors de la creation " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}








    @PutMapping("/editSession/{id}")
//    Session modiSess(@PathVariable("id") Long id, @RequestBody Session session){
//        return sessionService.editsession(id,session);
//    }
    public ResponseEntity<Session> modiSess(@PathVariable("id") Long id, @RequestBody Session session) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sessionService.editsession(id,session));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }








    @GetMapping("/getAllSess")
//    List<Session> tousSess(){
//        return sessionService.listSess();
//    }
    public ResponseEntity<List<Session>>  tousSess(){
        return ResponseEntity.status(HttpStatus.OK).body(sessionService.listSess());
    }












    @DeleteMapping("/suppSess/{id}")
//    String suppInsc(@PathVariable("id") Long id){
//        sessionService.deletesession(id);
//        return "Session supprimer avec succès";
//    }
//}

    public ResponseEntity<String> suppriSess(@PathVariable("id") Long id) {
        try {
            sessionService.deletesession(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Session supprimée avec succès");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
