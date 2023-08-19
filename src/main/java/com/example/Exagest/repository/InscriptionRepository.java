package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Examen;
import com.example.Exagest.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long>  {
    @Query("SELECT i FROM Inscription i ORDER BY i.enrolement.id ASC")
    List<Inscription> listEnrol();

    @Query("SELECT i FROM Inscription i ORDER BY i.annee.id ASC")
    List<Inscription> listAnn();

    @Query("SELECT i FROM Inscription i ORDER BY i.eleve.nom ")
    List<Inscription> listElev();

    @Query("SELECT i FROM Inscription i ORDER BY i.ecole.nomEcole ")
    List<Inscription> listEcol();

    @Query("SELECT i FROM Inscription i WHERE i.enrolement.examen.id = :idEx")
    List<Inscription> listInscPerExam(@Param("idEx") Long id);

/*    @Query("SELECT i FROM Inscription i WHERE i.enrolement.examen.id = ?1 AND i.moyenne.session.id =  ?2")
    List<Inscription> listInscPerExamSession(Long idExamen,Long idSession);*/

    @Query("SELECT i FROM Inscription i WHERE i.enrolement.ecole.id = ?1 AND i.enrolement.examen.id = ?2")
    List<Inscription> listInscPerEcolAndExam(Long idEcole,Long idExamen);

    @Query("SELECT i FROM Inscription i WHERE i.eleve.id = ?1 AND i.enrolement.examen.id = ?2")
    List<Inscription> listInscDesElevPerExam(Long idElev,Long idExamen);

//
//    @Query("SELECT COUNT(e) * COUNT(DISTINCT i.eleve) " +
//            "FROM Inscription i " +
//            "JOIN i.enrolement.examen er " +
//            "JOIN i.eleve el " +
//            "JOIN Moyenne m on m.inscription = i " +
//            "WHERE m.examen = ?1 AND m.moyenneTotale >= 10 AND ex.session = ?2")
//    Long calculateTotalInscribedAndPassed(Long idsession,Long idexamen);




}
