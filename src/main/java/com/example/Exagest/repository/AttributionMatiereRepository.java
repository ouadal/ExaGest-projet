package com.example.Exagest.repository;

import com.example.Exagest.entities.AttributionMatiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttributionMatiereRepository extends JpaRepository<AttributionMatiere,Long > {
    @Query("SELECT a FROM AttributionMatiere a ORDER BY a.annee.id ASC ")
    List<AttributionMatiere> listattributionMatAnne();

    @Query("SELECT a FROM AttributionMatiere a ORDER BY a.examen.libele ")
    List<AttributionMatiere> listattributionMatExam();

    @Query("SELECT a FROM AttributionMatiere a ORDER BY a.matiere.libele ")
    List<AttributionMatiere> listattributionMatMatiere();
}
