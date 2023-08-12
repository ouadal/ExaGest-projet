package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.MoyenneService;
import com.example.Exagest.entities.*;
import com.example.Exagest.repository.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
@Service
@Transactional
public class MoyenneServiceImpl implements MoyenneService {
    private final MoyenneRepository moyenneRepository;

    private final InscriptionRepository inscriptionRepository;

    private final ExamenRepository examenRepository;

    private final SessionRepository sessionRepository;

    private final NoteRepository noteRepository;

    public MoyenneServiceImpl(MoyenneRepository moyenneRepository, InscriptionRepository inscriptionRepository, ExamenRepository examenRepository, SessionRepository sessionRepository, NoteRepository noteRepository) {
        this.moyenneRepository = moyenneRepository;
        this.inscriptionRepository = inscriptionRepository;
        this.examenRepository = examenRepository;
        this.sessionRepository = sessionRepository;
        this.noteRepository = noteRepository;
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
    public Moyenne editmoyenne(Long id, Moyenne moyenne) {
        Optional<Moyenne> optionalMoyenne = moyenneRepository.findById(id);
        if (optionalMoyenne.isEmpty()) {
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
        return moyenneRepository.moyennePerExamLorsSessforAllEcol(idExamen, idSession);
    }

    @Override
    public List<Moyenne> moyennePerExamLorsSessforUneEcol(Long idExamen, Long idSession, Long idEcole) {
        return moyenneRepository.moyennePerExamLorsSessforUneEcol(idExamen, idSession, idEcole);
    }


    @Override
    public void calculerMoyenne(Long idExamen, Long idInscription, Long idSession) {
        Optional<Session> session = sessionRepository.findById(idSession);
        Optional<Examen> examen = examenRepository.findById(idExamen);
        Optional<Inscription> inscription = inscriptionRepository.findById(idInscription);

        if (session.isPresent() && examen.isPresent() && inscription.isPresent()) {
            Optional<Moyenne> moyenneDeLEleveOptional = moyenneRepository.findByIdSessionIdInscriptionAndIdExamen(idSession,idInscription,idExamen);
            List<Note> notes = noteRepository.listNoteElevPerExamenSession(idExamen, idInscription, idSession);
            double sommeNote = 0;
            double sommeCoeff = 0;
            for (Note note : notes) {
                sommeCoeff += note.getAttributionMatiere().getCoefficient();
                sommeNote += (note.getNoteExam() * note.getAttributionMatiere().getCoefficient());
            }

            if (sommeCoeff != 0) {
                double moyenneTotale = sommeNote / sommeCoeff;
                if(moyenneDeLEleveOptional.isPresent()){
                    moyenneDeLEleveOptional.get().setUpdateDate(LocalDate.now());
                    moyenneDeLEleveOptional.get().setMoyenneTotale(moyenneTotale);
                    moyenneRepository.save(moyenneDeLEleveOptional.get());
                }else {
                    moyenneRepository.save(new Moyenne(null,moyenneTotale,inscription.get(),examen.get(),session.get(),null,LocalDate.now()));
                    System.out.println("La moyenne est : " + moyenneTotale);
                }
            } else {
                throw new ArithmeticException("\n" + "Erreur de division par zéro : la somme des coefficients est nulle.");
            }
        } else {
            // Gérez le cas où l'une des entités n'existe pas dans la base de données
            throw new IllegalArgumentException("Invalid session, exam, ou inscription ID.");
        }

        this.assigneRang(idExamen,idSession);
        this.traiter(idExamen,idSession);

    }

    @Override
    public void genererMoyenne(Long idExamen, Long idSession) {
        List<Note> moyenneDejaGeneree = noteRepository.listNotePerExamSesion(idExamen, idSession);

        if (moyenneDejaGeneree.size()>1) {
            List<Inscription> inscriptions = inscriptionRepository.listInscPerExam(idExamen);

            for (Inscription inscription : inscriptions) {
                calculerMoyenne(idExamen, inscription.getId(), idSession);
            }
        } else {
            System.out.println("Les moyennes pour cet examen et cette session ont déjà été générées.");
        }
    }


    @Override
    public Moyenne findByIdOfMoy(Long id) {
        return moyenneRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Moyenne> listAll(Long id, Long id2) {
        return moyenneRepository.listMoyenneExam2(id,id2);
    }

    public void assigneRang(Long idExamen, Long idSession){

        List<Moyenne> moyennes3 = moyenneRepository.listMoyenneExam2(idExamen,idSession);

        Collections.sort(moyennes3, Comparator.comparingDouble(m -> -m.getMoyenneTotale())); // Tri décroissant

        int rangs = 1;
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < moyennes3.size(); i++) {
            Moyenne moyenne = moyennes3.get(i);
            if (i > 0 && moyenne.getMoyenneTotale() < moyennes3.get(i - 1).getMoyenneTotale()) {
                rangs = i + 1;
            }

            if (rangs == 1) {
                if (i > 0 && moyenne.getMoyenneTotale() == moyennes3.get(i - 1).getMoyenneTotale()) {
                    System.out.println("Rang : " + rangs + "er(ère)ex");

                    moyenne.setRangGenerale(rangs + "er(ère)ex");

                } else {
                    System.out.println("Rang : " + rangs + "er(ère)");
                    moyenne.setRangGenerale(rangs + "er(ère)");
                }
            } else {
                if (i > 0 && moyenne.getMoyenneTotale() == moyennes3.get(i - 1).getMoyenneTotale()) {
                    System.out.println("Rang : " + rangs + "èmeEx");
                    moyenne.setRangGenerale( rangs + "èmeEx");
                } else {
                    System.out.println("Rang : " + rangs + "ème");
                    moyenne.setRangGenerale( rangs + "ème");
                }
            }

            moyenneRepository.save(moyenne);

        // Afficher les rangs stockés dans la liste

        }




    }

    public void assigneRangEcole(Long idExamen,Long ecole, Long idSession){

        List<Moyenne> moyennes3 = moyenneRepository.listMoyenneExamParEcole(idExamen,idSession,ecole);

        Collections.sort(moyennes3, Comparator.comparingDouble(m -> -m.getMoyenneTotale())); // Tri décroissant

        int rangs = 1;
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < moyennes3.size(); i++) {
            Moyenne moyenne = moyennes3.get(i);
            if (i > 0 && moyenne.getMoyenneTotale() < moyennes3.get(i - 1).getMoyenneTotale()) {
                rangs = i + 1;
            }

            if (rangs == 1) {
                if (i > 0 && moyenne.getMoyenneTotale() == moyennes3.get(i - 1).getMoyenneTotale()) {
                    System.out.println("Rang : " + rangs + "er(ère)ex");

                    moyenne.setRangEcole(rangs + "er(ère)ex");

                } else {
                    System.out.println("Rang : " + rangs + "er(ère)");
                    moyenne.setRangEcole(rangs + "er(ère)");
                }
            } else {
                if (i > 0 && moyenne.getMoyenneTotale() == moyennes3.get(i - 1).getMoyenneTotale()) {
                    System.out.println("Rang : " + rangs + "èmeEx");
                    moyenne.setRangEcole( rangs + "èmeEx");
                } else {
                    System.out.println("Rang : " + rangs + "ème");
                    moyenne.setRangEcole( rangs + "ème");
                }
            }

            moyenneRepository.save(moyenne);

            // Afficher les rangs stockés dans la liste

        }




    }

    public void traiter(Long idExamen,Long idSession){

        List<Ecole> ecoles = moyenneRepository.listeEcole(idExamen);
        for (Ecole e : ecoles
             ) {
            this.assigneRangEcole(idExamen,e.getId(),idSession);
        }
    }
}
