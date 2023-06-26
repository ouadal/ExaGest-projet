package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Cycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CycleRepository extends JpaRepository<Cycle, Long>  {
    @Query("select c from Cycle c orderBy c.libelle ")
    List<Cycle> listcycle();
}
