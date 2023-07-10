package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.NoteService;
import com.example.Exagest.entities.*;
import com.example.Exagest.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    private final SessionRepository sessionRepository;
    private final ExamenRepository examenRepository;
    private final AttributionMatiereRepository attributionMatiereRepository;

    private final InscriptionRepository inscriptionRepository;

    public NoteServiceImpl(NoteRepository noteRepository, SessionRepository sessionRepository, ExamenRepository examenRepository, AttributionMatiereRepository attributionMatiereRepository, InscriptionRepository inscriptionRepository) {
        this.noteRepository = noteRepository;
        this.sessionRepository = sessionRepository;
        this.examenRepository = examenRepository;
        this.attributionMatiereRepository = attributionMatiereRepository;
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public Note addnote(Note note) {
        note.setAddDate(LocalDate.now());
        Optional<Inscription> in = inscriptionRepository.findById(note.getInscription().getId());
        Optional<Session> se = sessionRepository.findById(note.getSession().getId());
        Optional<AttributionMatiere> att = attributionMatiereRepository.findById(note.getAttributionMatiere().getId());
        Optional<Examen> ex = examenRepository.findById(note.getExamen().getId());
        if (in.isPresent() && se.isPresent() && att.isPresent() && ex.isPresent()){
            note.setExamen(ex.get());
            note.setSession(se.get());
            note.setInscription(in.get());
            note.setAttributionMatiere(att.get());

            return noteRepository.save(note);
        }
        return noteRepository.save(note);
    }

    @Override
    public Note editnote(Long id,Note note) {
        Optional<Note> optionalNote =noteRepository.findById(id);
        if(optionalNote.isEmpty()){
            System.out.println("Note modifié avec succès");
        }
        Note dbNote = optionalNote.get();
        dbNote.setUpdateDate(LocalDate.now());
        dbNote.setNoteExam(note.getNoteExam());
        dbNote.setExamen(note.getExamen());
        dbNote.setInscription(note.getInscription());
        dbNote.setAttributionMatiere(note.getAttributionMatiere());
        dbNote.setSession(note.getSession());
        dbNote.setStatut(note.isStatut());
        return noteRepository.save(dbNote);
    }

    @Override
    public String deletenote(Long id) {
        noteRepository.deleteById(id);
        return "Note supprimer avec succès";
    }


    @Override
    public List<Note> listSess() {
        return noteRepository.listSess();
    }

    @Override
    public List<Note> listAttriuMat() {
        return noteRepository.listAttriuMat();
    }

    @Override
    public List<Note> listInsc() {
        return noteRepository.listInsc();
    }

    @Override
    public List<Note> listeNotElePerAnnSessExam(String anneeID, String sessionID, String examID)
    {
        return noteRepository.listeNotElePerAnnSessExam(anneeID,sessionID, examID);
    }



    @Override
    public List<Note>  genererNoteParDefaut(Long idExamen , Long idSession) {
        List<AttributionMatiere> listAttriMat = attributionMatiereRepository.listAttMAtPereExam(idExamen);
        if (listAttriMat.isEmpty()) {
            System.out.println("vide");
        }
        Optional<Session> session = sessionRepository.findById(idSession);
        for (int i = 0; i < listAttriMat.size(); i++) {
            AttributionMatiere attributionMatiere = listAttriMat.get(i);
            List<Inscription> listInsc = inscriptionRepository.listInscPerExam(idExamen);
            for (int j = 0; j < listInsc.size(); j++) {
                Inscription inscription = listInsc.get(j);
                Note note = new Note(null, false, 0, inscription, attributionMatiere, session.get(), attributionMatiere.getExamen(), LocalDate.now(), null);
//                note.setAttributionMatiere(attributionMatiere);
//                note.setInscription(inscription);
//                note.setSession(session.orElse(null));
//                note.setExamen(new Examen());
                // Complétez ici avec d'autres attributs de l'objet Note, le cas échéant
                noteRepository.save(note);
            }
        }

        return noteRepository.listNotePerExam(idExamen);
    }
}
