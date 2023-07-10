package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.AttributionMatiereService;
import com.example.Exagest.entities.*;
import com.example.Exagest.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class AttributionMatiereServiceImpl implements AttributionMatiereService {
    private final AttributionMatiereRepository attributionMatiereRepository;
    private final AnneeRepository anneeRepository;

    private final MatiereRepository matiereRepository;

    private final ExamenRepository examenRepository;

    private final SessionRepository sessionRepository;

    private final InscriptionRepository inscriptionRepository;

    private final EcoleRepository ecoleRepository;

    private final CycleTypeExamenRepository cycleTypeExamenRepository;

    private final NoteRepository noteRepository;


    public AttributionMatiereServiceImpl(AttributionMatiereRepository attributionMatiereRepository, AnneeRepository anneeRepository, MatiereRepository matiereRepository, ExamenRepository examenRepository, SessionRepository sessionRepository, InscriptionRepository inscriptionRepository, EcoleRepository ecoleRepository, CycleTypeExamenRepository cycleTypeExamenRepository, NoteRepository noteRepository) {
        this.attributionMatiereRepository = attributionMatiereRepository;
        this.anneeRepository = anneeRepository;
        this.matiereRepository = matiereRepository;
        this.examenRepository = examenRepository;
        this.sessionRepository = sessionRepository;
        this.inscriptionRepository = inscriptionRepository;
        this.ecoleRepository = ecoleRepository;
        this.cycleTypeExamenRepository = cycleTypeExamenRepository;
        this.noteRepository = noteRepository;
    }

    @Override
    public AttributionMatiere addattMat(AttributionMatiere attributionMatiere) {

        Annee a = anneeRepository.getCurrentYear();
        attributionMatiere.setAddDate(LocalDate.now());
        Optional<Matiere> mat = matiereRepository.findById(attributionMatiere.getMatiere().getId());
//        if (mat.isPresent()){
//            attributionMatiere.setMatiere(mat.get());
//            return attributionMatiereRepository.save(attributionMatiere);
//        }
        Optional<Annee> an = anneeRepository.findById(attributionMatiere.getAnnee().getId());
//        if (an.isPresent()){
//            attributionMatiere.setAnnee(an.get());
//            return attributionMatiereRepository.save(attributionMatiere);
//        }
        Optional<Examen> ex = examenRepository.findById(attributionMatiere.getExamen().getId());
//        if (ex.isPresent()){
//            attributionMatiere.setExamen(ex.get());
//            return attributionMatiereRepository.save(attributionMatiere);
//        }


        if(mat.isPresent() && an.isPresent() && ex.isPresent()){
            attributionMatiere.setMatiere(mat.get());
            attributionMatiere.setAnnee(an.get());
            attributionMatiere.setExamen(ex.get());
            return attributionMatiereRepository.save(attributionMatiere);

        }

        return attributionMatiereRepository.save(attributionMatiere);
    }

    @Override
    public AttributionMatiere editattMat(Long id, AttributionMatiere attributionMatiere) {
        Optional<AttributionMatiere> optionalAttributionMatiere = attributionMatiereRepository.findById(id);
        if(optionalAttributionMatiere.isEmpty()){
            System.out.println("Attribution Matiere modifié avec succès");
        }
        AttributionMatiere dbAttributionMat = optionalAttributionMatiere.get();
        dbAttributionMat.setUpdateDate(LocalDate.now());
        dbAttributionMat.setMatiere(attributionMatiere.getMatiere());
        dbAttributionMat.setExamen(attributionMatiere.getExamen());
        dbAttributionMat.setCoefficient(attributionMatiere.getCoefficient());
        dbAttributionMat.setAnnee(attributionMatiere.getAnnee());
        return attributionMatiereRepository.save(dbAttributionMat);
    }

    @Override
    public String deletattMat(Long id) {
         attributionMatiereRepository.deleteById(id);
         return  "AttributionMatiere supprimer avec succès ";
    }

    @Override
    public List<AttributionMatiere> listattributionMatAnne() {
        return attributionMatiereRepository.listattributionMatAnne();
    }

    @Override
    public List<AttributionMatiere> listattributionMatExam(Long id) {
        return attributionMatiereRepository.listAttMAtPereExam(id);
    }

    @Override
    public List<AttributionMatiere> listattributionMatMatiere() {
        return attributionMatiereRepository.listattributionMatMatiere();
    }








}
