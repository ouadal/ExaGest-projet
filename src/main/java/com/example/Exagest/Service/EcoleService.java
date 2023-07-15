package com.example.Exagest.Service;

import com.example.Exagest.entities.Ecole;

import java.util.List;

public interface EcoleService {
    Ecole addecole(Ecole ecole);
    Ecole editecole( Long id,Ecole ecole);
    String deleteecole(Long id);
    List<Ecole> listEcolCycle();
    List<Ecole> listNomEcol();

    public String generateMatricule(int length);
    List<Ecole> listeDesEcoleAunExam(Long idEx);

}
