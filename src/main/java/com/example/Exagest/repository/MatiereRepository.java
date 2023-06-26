package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.CycleTypeExamen;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatiereRepository extends JpaRepository<Matiere, Long>  {
    @Query("SELECT m FROM Matiere m ORDER BY m.libele ")
    List<Matiere> listMatLib();

    @Query("SELECT m FROM Matiere m ORDER BY m.typeMat.libele ")
    List<Matiere> listTypMat();
}
