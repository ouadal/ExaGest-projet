package com.example.Exagest.Service;

import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Session;

import java.util.List;

public interface AttributionMatiereService {
    AttributionMatiere addattMat(AttributionMatiere attributionMatiere);

    AttributionMatiere editattMat(Long id, AttributionMatiere attributionMatiere);

    String deletattMat(Long id);

    List<AttributionMatiere> listattributionMatAnne();

    List<AttributionMatiere> listattributionMatExam(Long id);

    List<AttributionMatiere> listattributionMatMatiere();


    AttributionMatiere findByIdOfAttMat(Long id);
}
