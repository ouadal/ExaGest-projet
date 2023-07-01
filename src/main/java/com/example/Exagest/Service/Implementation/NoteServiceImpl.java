package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.NoteService;
import com.example.Exagest.entities.Note;
import com.example.Exagest.repository.NoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note addnote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note editnote(Long id,Note note) {
        Optional<Note> optionalNote =noteRepository.findById(id);
        if(optionalNote.isEmpty()){
            System.out.println("Note modifié avec succès");
        }
        Note dbNote = optionalNote.get();
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
