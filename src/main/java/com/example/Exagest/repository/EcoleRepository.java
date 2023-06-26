package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.CycleTypeExamen;
import com.example.Exagest.entities.Ecole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EcoleRepository extends JpaRepository<Ecole, Long>  {
    @Query("SELECT e FROM Ecole e ORDER BY e.nomEcole ")
    List<Ecole> listNomEcol();

    @Query("SELECT e FROM Ecole e ORDER BY e.cycle.libele ")
    List<Ecole> listEcolCycle();

}
