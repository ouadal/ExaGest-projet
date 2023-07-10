package com.example.Exagest.Service;

import com.example.Exagest.entities.Eleve;
import com.example.Exagest.entities.Matiere;

import java.util.HashMap;
import java.util.List;

public interface MatiereService {
    Matiere addmatiere(Matiere matiere);
    Matiere editmatiere( Long id,Matiere matiere);
    String deleteMatiere(Long id);
    List<Matiere> listMatLib();
    List<Matiere> listTypMat();

    HashMap<String, List<Eleve>> matPerElv  ();
}
