package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.AttributionMatiereService;
import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.repository.AttributionMatiereRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional

public class AttributionMatiereServiceImpl implements AttributionMatiereService {
    private final AttributionMatiereRepository attributionMatiereRepository;

    public AttributionMatiereServiceImpl(AttributionMatiereRepository attributionMatiereRepository) {
        this.attributionMatiereRepository = attributionMatiereRepository;
    }

    @Override
    public AttributionMatiere addattMat(AttributionMatiere attributionMatiere) {
        return attributionMatiereRepository.save(attributionMatiere);
    }

    @Override
    public AttributionMatiere editattMat(Long id, AttributionMatiere attributionMatiere) {
        return null;
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
