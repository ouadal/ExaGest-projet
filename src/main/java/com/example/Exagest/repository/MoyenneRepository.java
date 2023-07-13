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

    @Query("select m from Moyenne m ORDER BY m.session.libele ")
    List<Moyenne> listSess();

    @Query("SELECT m FROM Moyenne m WHERE m.examen.id =?1 AND m.session.id=?2 ORDER BY m.moyenneTotale")
    List<Moyenne> moyennePerExamLorsSessforAllEcol(Long idExamen,Long idSession);

    @Query("SELECT m FROM Moyenne m WHERE m.examen.id =?1 AND m.session.id =?2 AND m.inscription.ecole.id = ?3 ORDER BY m.moyenneTotale")
    List<Moyenne> moyennePerExamLorsSessforUneEcol(Long idExamen,Long idSession,Long idEcole);

}
