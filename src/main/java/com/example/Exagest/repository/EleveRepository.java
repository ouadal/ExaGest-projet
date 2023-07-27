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

    @Query("SELECT n.inscription.eleve FROM Note n WHERE n.inscription.eleve.id = n.inscription.eleve.id and n.attributionMatiere.matiere.id= :id")
    List<Eleve> listElevMat(@Param("id") Long id);

    @Query("SELECT i.eleve FROM Inscription i WHERE i.ecole.id = ?1")
    List<Eleve> getAllElevByEcol(Long idEcole);
}
