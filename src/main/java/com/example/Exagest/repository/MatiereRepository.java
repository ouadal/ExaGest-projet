package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.CycleTypeExamen;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatiereRepository extends JpaRepository<Matiere, Long>  {
    @Query("select m from Matiere m orderBy m.libele ")
    List<Matiere> listMatLib();

    @Query("select m from Matiere m orderBy m.typeMat.id ")
    List<Matiere> listTypMat();
}
