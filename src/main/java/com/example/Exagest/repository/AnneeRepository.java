package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.AttributionMatiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnneeRepository extends JpaRepository<Annee , Long> {
    @Query("select a from Annee a orderBy a.id ")
    List<Annee> listAnnee();
}
