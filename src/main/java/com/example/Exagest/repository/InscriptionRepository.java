package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Examen;
import com.example.Exagest.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long>  {
    @Query("select i from Inscription i orderBy i.enrolement.id ")
    List<Inscription> listEnrol();

    @Query("select i from Inscription i orderBy i.annee.id ")
    List<Inscription> listAnn();

    @Query("select i from Inscription i orderBy i.eleve.id ")
    List<Inscription> listElev();

    @Query("select i from Inscription i orderBy e.ecole.id ")
    List<Inscription> listEcol();

}
