package com.example.Exagest.Service;

import com.example.Exagest.entities.Eleve;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.requests.InscriptionRequestModel;

import java.util.List;

public interface InscriptionService {
   Inscription addinscription(InscriptionRequestModel inscriptionRM);
    Inscription editinscriptionn( Long id,Inscription inscription);
    String deleteinscription(Long id);
    List<Inscription> listEcol();

    List<Inscription> listElev();

    List<Inscription> listAnn();

    List<Inscription> listEnrol();

 List<Inscription> listInscPerExam(Long id);


    Inscription findByIdOfInsc(Long id);
}
