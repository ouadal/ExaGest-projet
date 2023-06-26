package com.example.Exagest.Service;

import com.example.Exagest.entities.Eleve;

import java.util.List;

public interface EleveService {
    Eleve addeleve(Eleve eleve);
    Eleve editeleve( Long id,Eleve eleve);
    String deleteeleve(Long id);
    List<Eleve> listNom();
}
