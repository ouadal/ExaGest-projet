package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Exceptions.EntityNotFoundException;
import com.example.Exagest.Service.NoteService;
import com.example.Exagest.entities.*;
import com.example.Exagest.repository.*;
import com.example.Exagest.requests.NoteUpdate;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    private final SessionRepository sessionRepository;
    private final ExamenRepository examenRepository;
    private final AttributionMatiereRepository attributionMatiereRepository;

    private final InscriptionRepository inscriptionRepository;

    public NoteServiceImpl(NoteRepository noteRepository, SessionRepository sessionRepository, ExamenRepository examenRepository, AttributionMatiereRepository attributionMatiereRepository, InscriptionRepository inscriptionRepository) {
        this.noteRepository = noteRepository;
        this.sessionRepository = sessionRepository;
        this.examenRepository = examenRepository;
        this.attributionMatiereRepository = attributionMatiereRepository;
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public Note addnote(Note note) {
        note.setAddDate(LocalDate.now());
        Optional<Inscription> in = inscriptionRepository.findById(note.getInscription().getId());
        Optional<Session> se = sessionRepository.findById(note.getSession().getId());
        Optional<AttributionMatiere> att = attributionMatiereRepository.findById(note.getAttributionMatiere().getId());
        Optional<Examen> ex = examenRepository.findById(note.getExamen().getId());
        if (in.isPresent() && se.isPresent() && att.isPresent() && ex.isPresent()){
            note.setExamen(ex.get());
            note.setSession(se.get());
            note.setInscription(in.get());
            note.setAttributionMatiere(att.get());

            return noteRepository.save(note);
        }
        return noteRepository.save(note);
    }

    @Override
    public Note editnote(Note note,Long id) {
        Optional<Note> optionalNote =noteRepository.findById(id);
        if(optionalNote.isEmpty()){
            throw new EntityNotFoundException("Aucune note  retrouvée avec l'id"+id);
        }
        else {
            Note dbNote = optionalNote.get();
//            dbNote.setUpdateDate(LocalDate.now());
            dbNote.setNoteExam(note.getNoteExam());
//            dbNote.setExamen(note.getExamen());
//            dbNote.setAttributionMatiere(note.getAttributionMatiere());
//            dbNote.setSession(note.getSession());
//            dbNote.setStatut(note.isStatut());
            return noteRepository.save(dbNote);
        }

    }

    @Override
    public String deletenote(Long id) {
        noteRepository.deleteById(id);
        return "Note supprimer avec succès";
    }


    @Override
    public List<Note> listSess() {
        return noteRepository.listSess();
    }



    @Override
    public List<Note> listAttriuMat() {
        return noteRepository.listAttriuMat();
    }

    @Override
    public List<Note> listInsc() {
        return noteRepository.listInsc();
    }


    @Override
    public List<Note> listeNotElePerAnnSessExam(String anneeID, String sessionID, String examID)
    {
        return noteRepository.listeNotElePerAnnSessExam(anneeID,sessionID, examID);
    }



    @Override
    public List<Note> listNoteElevPerExamenSession(Long idExamen, Long idEcol, Long idSession)
    {
        return noteRepository.listNoteElevPerExamenSession(idExamen,  idEcol, idSession);
    }

    @Override
    public List<Note> mettreAjourLesNote(List<NoteUpdate> listNotes) {
        Long idSession = 0L;
        Long idExamen = 0L;
        for(NoteUpdate noteUpdate : listNotes){
            Note note = editnote(new Note(null,false,noteUpdate.getNoteExam(),null,null,null,null,null,null), noteUpdate.getId());
            idExamen = note.getExamen().getId();
            idSession = note.getSession().getId();
        }
        return noteRepository.listNotePerExamSesion(idExamen ,idSession);
    }

    @Override
    public Note findByIdOfNot(Long id) {
        return noteRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Note> listDesElevPerExamenSessionInscription(Long idExamen, Long idInscription, Long idSession) {
        return noteRepository.listDesElevPerExamenSessionInscription(idExamen,idInscription,idSession);
    }

    @Override
    public List<Note> findNotePerExamAttribSess(Long idExamen, Long idAttrMat, Long idSession) {
        return noteRepository.findNotePerExamAttribSess(idExamen,idAttrMat,idSession);
    }

    @Override
    public List<Note> listNotePerExamSesion(Long idExamen, Long idSession) {
        return noteRepository.listNotePerExamSesion(idExamen,idSession);
    }
    @Override
    public List<Note> listNotePerExamSesionMat(Long idExamen, Long idSession,Long idMat) {
        return noteRepository.listNotePerExamSesionMat(idExamen,idSession,idMat);
    }




    @Override
    public boolean genererNoteParDefaut(Long idExamen , Long idSession) {
        List<AttributionMatiere> listAttriMat = attributionMatiereRepository.listAttMAtPereExam(idExamen);
        List<Note> listNotePerExamSess = noteRepository.listNotePerExamSesion(idExamen,idSession);

        boolean reponse = false;
       if(listNotePerExamSess.size()>0){
           reponse = false;
       }
       else{
           if (listAttriMat.isEmpty()) {
               System.out.println("***********************************");
               System.out.println("vide");
               System.out.println("***********************************");
           }
           System.out.println("vide");
           System.out.println(listAttriMat.size());
           Optional<Session> session = sessionRepository.findById(idSession);
           for (int i = 0; i < listAttriMat.size(); i++) {
               AttributionMatiere attributionMatiere = listAttriMat.get(i);
               List<Inscription> listInsc = inscriptionRepository.listInscPerExam(idExamen);
               for (int j = 0; j < listInsc.size(); j++) {
                   Inscription inscription = listInsc.get(j);
                   Note note = new Note(null, false, 0, inscription, attributionMatiere, session.get(), attributionMatiere.getExamen(), LocalDate.now(), null);
                   noteRepository.save(note);
               }
           }

           reponse = true;

       }

        return reponse;
    }






//   @Override
//   public void calculerMoyenne(Long idExamen, Long idInscription, Long idSession) {
//       Optional<Session> session = sessionRepository.findById(idSession);
//       Optional<Examen> examen = examenRepository.findById(idExamen);
//       Optional<Inscription> inscription = inscriptionRepository.findById(idInscription);
//       double sommeCoeff;
//       if (session.isPresent() && examen.isPresent() && inscription.isPresent()) {
//           List<Note> notes = noteRepository.listNoteElevPerExamenSession(idExamen, idInscription, idSession);
//           double sommeNote = 0;
//           sommeCoeff = 0;
//           for (Note note : notes) {
//               sommeCoeff += note.getAttributionMatiere().getCoefficient();
//               sommeNote += (note.getNoteExam() * note.getAttributionMatiere().getCoefficient());
//           }
//
//           if (sommeCoeff != 0) {
//               double moyenne = sommeNote / sommeCoeff;
//               System.out.println("La moyenne est : " + moyenne);
//           } else {
//               throw new ArithmeticException("Division by zero error: sum of coefficients is zero.");
//           }
//       } else {
//           // Gérez le cas où l'une des entités n'existe pas dans la base de données
//           throw new IllegalArgumentException("Invalid session, exam, or inscription ID.");
//       }





}

