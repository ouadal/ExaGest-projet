package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Matiere;
import com.example.Exagest.entities.Moyenne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoyenneRepository extends JpaRepository<Moyenne, Long>  {
    @Query("SELECT m FROM Moyenne m ORDER BY m.inscription.id ASC")
    List<Moyenne> listIns();

    @Query("SELECT m FROM Moyenne m ORDER BY m.examen.libele ")
    List<Moyenne> listExam();

    @Query("select m from Moyenne m orderBy m.session.libele ")
    List<Moyenne> listSess();

}
