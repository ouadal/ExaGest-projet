package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExamenRepository extends JpaRepository<Examen, Long>  {
    @Query("SELECT e FROM Examen e ORDER BY e.libele ")
    List<Examen> listExameLib();

    @Query("SELECT e FROM Examen e ORDER BY e.annee.id ")
    List<Examen> listAnnee();


    @Query("SELECT e FROM Examen e ORDER BY e.ecole.nomEcole ")
    List<Examen> listEcol();

    @Query("SELECT e FROM Examen e WHERE e.ecole.id = ?1")
    List<Examen> listExamPerEcol(Long id);


}
