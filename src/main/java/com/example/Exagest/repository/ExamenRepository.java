package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExamenRepository extends JpaRepository<Examen, Long>  {
    @Query("select e from Examen e orderBy e.libele ")
    List<Examen> listExameLib();

    @Query("select e from Examen e orderBy e.annee.id ")
    List<Examen> listAnnee();

    @Query("select e from Examen e orderBy e.ecole.id ")
    List<Examen> listEcol();


}
