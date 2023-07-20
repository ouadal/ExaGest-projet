package com.example.Exagest.Service;

import com.example.Exagest.entities.Annee;

import java.util.List;

public interface AnneeService {
    Annee addAnnee(Annee annee);
    Annee editAnnee( Long id,Annee annee);
    String deleteAnnee(Long id);
    List<Annee> listAnne();

    Annee setCurrentYear(Long id);

    Annee findByIdOfAYear(Long id);
}
