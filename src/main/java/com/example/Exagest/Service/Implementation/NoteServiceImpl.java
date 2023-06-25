package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.NoteService;
import com.example.Exagest.entities.Note;
import com.example.Exagest.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

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
        dbNote.setDateAjout(note.getDateAjout());
        dbNote.setNoteExam(note.getNoteExam());
        dbNote.setCoefficient(note.getCoefficient());
        dbNote.setMoyenne(note.getMoyenne());
        dbNote.setParametrageExam(note.getParametrageExam());
        dbNote.setDateModife(note.getDateModife());
        dbNote.setStatut(note.isStatut());
        return noteRepository.save(dbNote);
    }

    @Override
    public String deletenote(Long id) {
        noteRepository.deleteById(id);
        return "Note supprimer avec succès";
    }

    @Override
    public List<Note> listnote() {
        return noteRepository.findAll();
    }
}
