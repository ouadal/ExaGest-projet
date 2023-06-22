package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Moyenne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoyenneRepository extends JpaRepository<Moyenne, Long>  {
}
