package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExamenRepository extends JpaRepository<Examen, Long>  {
    @Query("SELECT e FROM Examen e ORDER BY e.libele ")
    List<Examen> listExameLib();

    @Query("SELECT e FROM Examen e ORDER BY e.annee.id ")
    List<Examen> listAnnee();


    @Query("SELECT e FROM Examen e ORDER BY e.ecole.nomEcole DESC ")
    List<Examen> listEcol();

    @Query("SELECT e FROM Examen e WHERE e.ecole.id = ?1")
    List<Examen> listExamPerEcol(Long id);

    @Query("SELECT e FROM Examen e WHERE e.annee.etat = true AND e.ecole.id = ?1")
    List<Examen> listExamAucoursDuneAnee(Long id);

//    @Query("select e from Examen e where e.annee.etat = true and e.ecole.id=?1")
//    Examen setExamen(Long idEcol);
    @Modifying
    @Query("" +
            "UPDATE Examen e " +
            "SET e.statut=false " +
            "WHERE e.id <>  ?1 " +
            "AND e.ecole.id =?2 " +
            "AND e.annee.id=?3" )
    void setToFalseAllExamDiffOf(Long idExamen,Long idEcol,Long idAnnee);

    @Modifying
    @Query("update Examen e set e.statut = false WHERE e.id = ?1")
    void setExamFalse(Long id);





}
