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
}
