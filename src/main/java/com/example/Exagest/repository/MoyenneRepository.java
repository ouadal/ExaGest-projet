package com.example.Exagest.repository;

import com.example.Exagest.entities.Ecole;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.entities.Moyenne;
import com.example.Exagest.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MoyenneRepository extends JpaRepository<Moyenne, Long>  {
    @Query("SELECT m FROM Moyenne m ORDER BY m.inscription.id ASC")
    List<Moyenne> listIns();

    @Query("SELECT m FROM Moyenne m ORDER BY m.examen.libele ")
    List<Moyenne> listExam();

    @Query("select m from Moyenne m ORDER BY m.session.libele DESC")
    List<Moyenne> listSess();

    @Query("SELECT DISTINCT m FROM Moyenne m WHERE m.examen.id =?1 AND m.session.id=?2 ORDER BY m.moyenneTotale DESC")
    List<Moyenne> moyennePerExamLorsSessforAllEcol(Long idExamen,Long idSession);

    @Query("SELECT DISTINCT m FROM Moyenne m WHERE m.examen.id =?1 AND m.session.id =?2 AND m.inscription.ecole.id = ?3 ORDER BY m.moyenneTotale DESC")
    List<Moyenne> moyennePerExamLorsSessforUneEcol(Long idExamen,Long idSession,Long idEcole);

    @Query("SELECT m FROM Moyenne m WHERE m.session.id=?1 AND m.inscription.id =?2 AND m.examen.id=?3")
    Optional<Moyenne> findByIdSessionIdInscriptionAndIdExamen(Long idSession, Long idInscription, Long idExamen);

    @Query("SELECT m.moyenneTotale FROM Moyenne m WHERE   m.examen.id=?1 AND m.session.id=?2 ")
    Double[] listMoyenneExam(Long idExamen, Long idSession);

    @Query("SELECT m FROM Moyenne m WHERE   m.examen.id=?1 AND m.session.id=?2 ")
    List<Moyenne>listMoyenneExam2(Long idExamen, Long idSession);

    @Query("SELECT m FROM Moyenne m WHERE   m.examen.id=?1 AND m.session.id=?2 order by m.inscription.ecole.nomEcole,m.rangGenerale ASC,m.rangEcole")
    List<Moyenne>listMoyenneExamOudal(Long idExamen, Long idSession);
    @Query("SELECT m FROM Moyenne m WHERE   m.examen.id=?1 AND m.session.id=?2 AND m.inscription.ecole.id=?3 ")
    List<Moyenne>listMoyenneExamParEcole(Long idExamen, Long idSession,Long ecole);

    @Query("SELECT m.inscription.ecole FROM Moyenne m WHERE   m.examen.id=?1 ")
    List<Ecole> listeEcole(Long idExamen);

    @Query("SELECT m FROM Moyenne m WHERE   m.examen.id=?1 AND m.session.id=?2 order by m.rangGenerale")
    List<Moyenne> listMoyenneExamOudalReport(Long idExam, Long idSection);
    @Query("SELECT m FROM Moyenne m WHERE   m.examen.id=?1 AND m.session.id=?2 and m.inscription.ecole.id=?3 order by m.rangEcole")
    List<Moyenne> listMoyenneExamOudalReportEcole(Long idExam, Long idSection, Long idEcole);

    @Query("SELECT n FROM Note n WHERE n.examen.id=?1 AND n.session.id=?2 order by n.inscription.eleve.nom,n.inscription.eleve.prenom,n.attributionMatiere.matiere.typeMat.libele," +
            "n.attributionMatiere.matiere.libele ")
    List<Note> relever(Long idExam, Long idSection);

    @Query("SELECT m.moyenneTotale FROM Moyenne m WHERE m.inscription=?1 AND m.session.id=?2 ")
    Double findByInscrit(Inscription inscription, Long idSection);

    @Query("SELECT m FROM Moyenne m WHERE m.inscription=?1 AND m.session.id=?2 ")
    Moyenne findByInscrit2(Inscription inscription, Long idSection);
}
