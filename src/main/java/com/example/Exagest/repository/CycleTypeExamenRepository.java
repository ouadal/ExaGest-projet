package com.example.Exagest.repository;

import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.CycleTypeExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CycleTypeExamenRepository extends JpaRepository<CycleTypeExamen, Long>  {
    @Query("select c from CycleTypeExamen c orderBy c.cycle.id ")
    List<CycleTypeExamen> listCycle();

    @Query("select c from CycleTypeExamen c orderBy c.typeExamen.id ")
    List<CycleTypeExamen> listtypeExamen();
}
