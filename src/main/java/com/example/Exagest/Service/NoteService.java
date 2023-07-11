package com.example.Exagest.Service;

import com.example.Exagest.entities.Note;
import org.aspectj.weaver.ast.Not;

import java.util.List;

public interface NoteService {
    Note addnote(Note note);

    Note editnote( Note note,Long id);

    String deletenote(Long id);

    List<Note> listSess();

    List<Note> listAttriuMat();

    List<Note> listInsc();

    List<Note> listeNotElePerAnnSessExam(String anneeID, String sessionID,String examID);

    List<Note>  genererNoteParDefaut(Long idExamen , Long idSession) ;

    List<Note> listNoteElevPerExamenSession( Long idExamen, Long idInscription, Long idSession);


    void calculerMoyenne(Long idExamen, Long idInscription, Long idSession);
}
