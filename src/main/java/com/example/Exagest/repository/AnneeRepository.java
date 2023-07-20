package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.AttributionMatiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnneeRepository extends JpaRepository<Annee , Long> {
    @Query("SELECT a FROM Annee a ORDER BY a.id ASC")
    List<Annee> listAnnee();

    @Query("SELECT a FROM Annee a WHERE a.etat=true")
    Annee getCurrentYear();



    @Modifying
      @Query("update Annee a set a.etat = false")
    void setCurrentYear();



    @Query("SELECT a FROM Annee a WHERE a.etat=FALSE ")
    Annee findAnneeByIdTrue();

}
