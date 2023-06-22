package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Ecole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EcoleRepository extends JpaRepository<Ecole, Long>  {
}
