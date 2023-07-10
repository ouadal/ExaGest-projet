package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Examen;
import com.example.Exagest.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long>  {
    @Query("SELECT i FROM Inscription i ORDER BY i.enrolement.id ASC")
    List<Inscription> listEnrol();

    @Query("SELECT i FROM Inscription i ORDER BY i.annee.id ASC")
    List<Inscription> listAnn();

    @Query("SELECT i FROM Inscription i ORDER BY i.eleve.nom ")
    List<Inscription> listElev();

    @Query("SELECT i FROM Inscription i ORDER BY i.ecole.nomEcole ")
    List<Inscription> listEcol();

    @Query("SELECT i FROM Inscription i WHERE i.enrolement.examen.id = :idEx ")
    List<Inscription> listInscPerExam(@Param("idEx") Long id);



}
