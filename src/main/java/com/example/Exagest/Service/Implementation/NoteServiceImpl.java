package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.NoteService;
import com.example.Exagest.entities.Note;
import com.example.Exagest.repository.NoteRepository;

import java.util.List;

public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note addnote(Note note) {
        return null;
    }

    @Override
    public Note editnote(Long id) {
        return null;
    }

    @Override
    public String deletenote(Long id) {
        return null;
    }

    @Override
    public List<Note> listnote() {
        return null;
    }
}
