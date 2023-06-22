package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.TypeExamen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeExamenRepository extends JpaRepository<TypeExamen, Long>  {
}
