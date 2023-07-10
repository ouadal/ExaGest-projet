package com.example.Exagest.Service;

import com.example.Exagest.entities.AttributionMatiere;
import com.example.Exagest.entities.Eleve;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EleveService {
    Eleve addeleve(Eleve eleve);

    Eleve editeleve( Long id,Eleve eleve);

    String deleteeleve(Long id);

    List<Eleve> listNom();

    List<Eleve> listElevMat(@Param("id") Long id);


}
