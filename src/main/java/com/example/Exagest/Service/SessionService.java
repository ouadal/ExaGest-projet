package com.example.Exagest.Service;

import com.example.Exagest.entities.Session;

import java.util.List;

public interface SessionService {
   Session addsession(Session session);
   Session editsession(Long id, Session session);
    String deletesession(Long id);
    List<Session> listSess();

}
