package com.example.Exagest.Service;

import com.example.Exagest.entities.Note;
import org.aspectj.weaver.ast.Not;

import java.util.List;

public interface NoteService {
    Note addnote(Note note);

    Note editnote( Long id,Note note);

    String deletenote(Long id);

    List<Note> listnote();

    List<Note> listSess();

    List<Note> listAttriuMat();

    List<Note> listInsc();
}
