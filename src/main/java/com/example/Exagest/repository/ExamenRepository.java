package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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




//    @Query("SELECT e.ecole.nomEcole, " +
//            "COUNT(CASE WHEN n.statut = true THEN 1 ELSE NULL END) * 100.0 / COUNT(n) AS tauxReussite " +
//            "FROM Examen e " +
//            "JOIN e.notes n " +
//            "JOIN e.ecole ec " +
//            "GROUP BY e.ecole.nomEcole")
//    List<Object[]> calculateTauxReussiteByEcole();
//    //List<Examen> calculateTauxReussiteByEcole();

    @Query("SELECT " +
            "((COUNT(CASE WHEN m.moyenneTotale >= 10 THEN 1 ELSE NULL END) / COUNT(DISTINCT i.eleve) )*  100) " +
            "FROM Moyenne m " +
            "JOIN m.inscription i " +
            "WHERE m.examen.id = ?1 AND m.session.id = ?2 AND m.inscription.ecole.id=?3")
    Double calculateTotalInscribedAndPassed(Long idsession,Long idexamen,Long ecole);
    @Query("SELECT " +
            "(COUNT(CASE WHEN m.moyenneTotale >= 10 THEN 1 ELSE NULL END) * COUNT(DISTINCT i.eleve) * 1.0 / COUNT(DISTINCT CASE WHEN e.sexe = :sexe THEN i.eleve ELSE NULL END)) " +
            "FROM Moyenne m " +
            "JOIN m.inscription i " +
            "JOIN i.eleve e " +
            "WHERE m.examen.id = :examenId AND m.session.id = :sessionId AND i.ecole.id = :ecoleId")
    Double calculateTauxReussiteBySexe(@Param("sessionId") Long sessionId, @Param("examenId") Long examenId, @Param("ecoleId") Long ecoleId, @Param("sexe") String sexe);



}
