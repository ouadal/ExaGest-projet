package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Matiere;
import com.example.Exagest.entities.Moyenne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoyenneRepository extends JpaRepository<Moyenne, Long>  {
    @Query("select m from Moyenne m orderBy m.inscription.id ")
    List<Moyenne> listIns();

    @Query("select m from Moyenne m orderBy m.examen.id ")
    List<Moyenne> listExam();

    @Query("select m from Moyenne m orderBy m.session.id ")
    List<Moyenne> listSess();

}
