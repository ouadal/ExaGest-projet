package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.MoyenneService;
import com.example.Exagest.entities.*;
import com.example.Exagest.repository.ExamenRepository;
import com.example.Exagest.repository.InscriptionRepository;
import com.example.Exagest.repository.MoyenneRepository;
import com.example.Exagest.repository.SessionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MoyenneServiceImpl implements MoyenneService {
    private final MoyenneRepository moyenneRepository;

    private final InscriptionRepository inscriptionRepository;

    private final ExamenRepository examenRepository;

    private final SessionRepository sessionRepository;

    public MoyenneServiceImpl(MoyenneRepository moyenneRepository, InscriptionRepository inscriptionRepository, ExamenRepository examenRepository, SessionRepository sessionRepository) {
        this.moyenneRepository = moyenneRepository;
        this.inscriptionRepository = inscriptionRepository;
        this.examenRepository = examenRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public Moyenne addmoyenne(Moyenne moyenne) {
        moyenne.setAddDate(LocalDate.now());
        Optional<Inscription> in = inscriptionRepository.findById(moyenne.getInscription().getId());
        Optional<Session> se = sessionRepository.findById(moyenne.getSession().getId());
        Optional<Examen> ex = examenRepository.findById(moyenne.getExamen().getId());
        if (in.isPresent() && se.isPresent() && in.isPresent() && ex.isPresent()) {
            moyenne.setExamen(ex.get());
            moyenne.setSession(se.get());
            moyenne.setInscription(in.get());
            return moyenneRepository.save(moyenne);
        }
        return moyenne;
    }

    @Override
    public Moyenne editmoyenne(Long id,Moyenne moyenne) {
          Optional<Moyenne> optionalMoyenne = moyenneRepository.findById(id);
        if(optionalMoyenne.isEmpty()){
            System.out.println("Moyenne modifié avec succès");
        }
        Moyenne dbMoyenne = optionalMoyenne.get();
        dbMoyenne.setUpdateDate(LocalDate.now());
        dbMoyenne.setExamen(moyenne.getExamen());
        dbMoyenne.setSession(moyenne.getSession());
        dbMoyenne.setInscription(moyenne.getInscription());
        return moyenneRepository.save(dbMoyenne);
    }

    @Override
    public String deletemoyenne(Long id) {
        moyenneRepository.deleteById(id);
        return "Moyenne supprimer avec succès";
    }

    @Override
    public List<Moyenne> listIns() {
        return moyenneRepository.listIns();
    }

    @Override
    public List<Moyenne> listExam() {
        return moyenneRepository.listExam();
    }

    @Override
    public List<Moyenne> listSess() {
        return moyenneRepository.listSess();
    }

    @Override
    public List<Moyenne> moyennePerExamLorsSessforAllEcol(Long idExamen, Long idSession) {
        return moyenneRepository.moyennePerExamLorsSessforAllEcol(idExamen,idSession);
    }

    @Override
    public List<Moyenne> moyennePerExamLorsSessforUneEcol(Long idExamen, Long idSession, Long idEcole) {
        return moyenneRepository.moyennePerExamLorsSessforUneEcol(idExamen,idSession,idEcole);
    }

}
