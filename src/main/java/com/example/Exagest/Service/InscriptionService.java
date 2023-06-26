package com.example.Exagest.Service;

import com.example.Exagest.entities.Inscription;

import java.util.List;

public interface InscriptionService {
   Inscription addinscription(Inscription inscription);
    Inscription editinscriptionn( Long id,Inscription inscription);
    String deleteinscription(Long id);
    List<Inscription> listEcol();

    List<Inscription> listElev();

    List<Inscription> listAnn();

    List<Inscription> listEnrol();


}
