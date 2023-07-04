package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Ecole;
import com.example.Exagest.entities.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EleveRepository extends JpaRepository<Eleve, Long>  {
    @Query("SELECT e FROM Eleve e ORDER BY e.nom ")
    List<Eleve> listNom();

    @Query("SELECT e FROM Note n , Eleve e WHERE n.inscription.eleve.id = e.id and n.attributionMatiere.matiere.id= :id")
    List<Eleve> listElevMat(@Param("id") Long id);
}
