package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Session;
import com.example.Exagest.entities.TypeExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeExamenRepository extends JpaRepository<TypeExamen, Long>  {
    @Query("SELECT t FROM TypeExamen t ORDER BY t.libele")
    List<TypeExamen> listtypeExamLib();
}
