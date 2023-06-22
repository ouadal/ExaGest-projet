package com.example.Exagest.Service;

import com.example.Exagest.entities.Note;
import org.aspectj.weaver.ast.Not;

import java.util.List;

public interface NoteService {
    Note addnote(Note note);
    Note editnote( Long id);
    String deletenote(Long id);
    List<Note> listnote();
}
