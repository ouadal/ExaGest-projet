package com.example.Exagest.controller;

import com.example.Exagest.Service.SessionService;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Session;
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
    Session ajouterSess(@RequestBody Session session){
        return sessionService.addsession(session);
    }

    @PutMapping("/editSession/{id}")
    Session modiSess(@PathVariable("id") Long id, @RequestBody Session session){
        return sessionService.editsession(id,session);
    }

    @GetMapping("/getAllSess")
    List<Session> tousSess(@RequestBody Session session){
        return sessionService.listSess();
    }


    @DeleteMapping("/suppSess/{id}")
    String suppInsc(@PathVariable("id") Long id){
        sessionService.deletesession(id);
        return "Session supprimer avec succès";
    }
}
