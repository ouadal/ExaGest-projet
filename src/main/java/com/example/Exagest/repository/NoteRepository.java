package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Moyenne;
import com.example.Exagest.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long>  {
    @Query("select n from Note n orderBy n.inscription.id ")
    List<Note> listInsc();

    @Query("select n from Note n orderBy n.attributionMatiere.id ")
    List<Note> listAttriuMat();

    @Query("select n from Note n orderBy n.inscription.id ")
    List<Note> listSess();

    @Query("select n from Note n orderBy n.examen.id ")
    List<Note> listExam();
}
