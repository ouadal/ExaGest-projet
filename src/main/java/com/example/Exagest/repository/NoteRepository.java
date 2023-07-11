package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Moyenne;
import com.example.Exagest.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long>  {
    @Query("SELECT n FROM Note n ORDER BY n.inscription.id ASC")
    List<Note> listInsc();

    @Query("SELECT n FROM Note n ORDER BY n.attributionMatiere.id ASC ")
    List<Note> listAttriuMat();

    @Query("SELECT n FROM Note n ORDER BY n.inscription.id ASC ")
    List<Note> listSess();

    @Query("SELECT  n FROM Note n ORDER BY n.examen.libele")
    List<Note> listExam();

    @Query("SELECT n FROM Note n  WHERE n.inscription.annee.id =?1 and n.session.id =?2 and n.examen.id=?3 ")
    List<Note> listeNotElePerAnnSessExam(String anneeID, String sessionID,String examID);

    @Query("SELECT DISTINCT n FROM Note n  WHERE n.examen.id=?1 ")
    List<Note> listNotePerExam(Long idExamen);

    @Query("SELECT n FROM Note n WHERE n.examen.id =?1 AND n.inscription.id =?2 AND n.session.id=?3 ")
    List<Note> listNoteElevPerExamenSession( Long idExamen, Long idInscription, Long idSession);
}
