package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Ecole;
import com.example.Exagest.entities.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EleveRepository extends JpaRepository<Eleve, Long>  {
    @Query("select e from Eleve e orderBy e.Nom ")
    List<Eleve> listNom();
}
