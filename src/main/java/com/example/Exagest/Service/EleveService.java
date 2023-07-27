package com.example.Exagest.Service;

import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Eleve;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.requests.InscriptionRequestModel;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EleveService {
    Eleve addeleve(InscriptionRequestModel inscriptionRM);

    Eleve editeleve( Long id,Eleve eleve);

    String deleteeleve(Long id);

    List<Eleve> listNom();

    List<Eleve> listElevMat(@Param("id") Long id);


    Eleve findByIdOfElev(Long id);

    List<Eleve> getAllElevByEcol(Long idEcole);
}
