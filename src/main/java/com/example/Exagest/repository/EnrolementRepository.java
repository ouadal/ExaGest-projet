package com.example.Exagest.repository;

import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Enrolement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrolementRepository extends JpaRepository<Enrolement, Long>  {
    @Query("SELECT e FROM Enrolement e ORDER BY e.examen.libele ")
    List<Enrolement> listExamen();

    @Query("select e from Enrolement e ORDER BY e.ecole.nomEcole ")
    List<Enrolement> listEcol();

    @Query("SELECT e FROM Enrolement e WHERE e.ecole.id = ?1")
    List<Enrolement> getAllEnrollementsByEcol(Long idEcole);
}
