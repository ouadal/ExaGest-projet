package com.example.Exagest.repository;

import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.CycleTypeExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CycleTypeExamenRepository extends JpaRepository<CycleTypeExamen, Long>  {
    @Query("SELECT c FROM CycleTypeExamen c ORDER BY c.cycle.libele ")
    List<CycleTypeExamen> listCycle();

    @Query("SELECT c FROM CycleTypeExamen c ORDER BY c.typeExamen.libele ")
    List<CycleTypeExamen> listtypeExamen();

    @Query("SELECT c FROM CycleTypeExamen c WHERE c.cycle.id = ?1")
    List<CycleTypeExamen> listtypeExamenPerCycle(Long idCycle);
}
