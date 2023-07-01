package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.AttributionMatiereService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Cycle;
import com.example.Exagest.repository.AnneeRepository;
import com.example.Exagest.repository.AttributionMatiereRepository;
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

    public AttributionMatiereServiceImpl(AttributionMatiereRepository attributionMatiereRepository, AnneeRepository anneeRepository) {
        this.attributionMatiereRepository = attributionMatiereRepository;
        this.anneeRepository = anneeRepository;
    }

    @Override
    public AttributionMatiere addattMat(AttributionMatiere attributionMatiere) {

        Annee a = anneeRepository.getCurrentYear();
        attributionMatiere.setAddDate(LocalDate.now());


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
    public List<AttributionMatiere> listattributionMatExam() {
        return attributionMatiereRepository.listattributionMatExam();
    }

    @Override
    public List<AttributionMatiere> listattributionMatMatiere() {
        return attributionMatiereRepository.listattributionMatMatiere();
    }

}
