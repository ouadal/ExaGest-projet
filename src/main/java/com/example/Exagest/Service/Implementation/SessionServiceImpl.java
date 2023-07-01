package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.SessionService;
import com.example.Exagest.entities.Session;
import com.example.Exagest.repository.SessionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }


    @Override
    public Session addsession(Session session) {
        session.setAddDate(LocalDate.now());
        return sessionRepository.save(session);
    }

    @Override
    public Session editsession(Long id, Session session) {
        Optional<Session> optionalSession =sessionRepository.findById(id);
        if(optionalSession.isEmpty()){
            System.out.println("Section modifié avec succès");
        }
        Session dbSession = optionalSession.get();
        dbSession.setUpdateDdate(LocalDate.now());
        dbSession.setLibele(session.getLibele());
        return sessionRepository.save(dbSession);

    }

    @Override
    public String deletesession(Long id) {
        sessionRepository.deleteById(id);
        return "session supprimer avec succès ";
    }

    @Override
    public List<Session> listSess() {
        return sessionRepository.listSess();
    }


}
