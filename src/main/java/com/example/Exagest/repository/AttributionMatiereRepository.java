package com.example.Exagest.repository;

import com.example.Exagest.entities.AttributionMatiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttributionMatiereRepository extends JpaRepository<AttributionMatiere,Long > {
    @Query("select a from AttributionMatiere a orderBy a.annee.id ")
    List<AttributionMatiere> listattributionMatAnne();

    @Query("select a from AttributionMatiere a orderBy a.examen.id ")
    List<AttributionMatiere> listattributionMatExam();

    @Query("select a from AttributionMatiere a orderBy a.matiere.id ")
    List<AttributionMatiere> listattributionMatMatiere();
}
