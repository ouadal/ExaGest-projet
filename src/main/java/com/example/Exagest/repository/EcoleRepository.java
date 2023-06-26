package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.CycleTypeExamen;
import com.example.Exagest.entities.Ecole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EcoleRepository extends JpaRepository<Ecole, Long>  {
    @Query("select e from Ecole e orderBy e.NomEcole ")
    List<Ecole> listNomEcol();

    @Query("select e from Ecole e orderBy e.cycle.id ")
    List<Ecole> listEcolCycle();

}
