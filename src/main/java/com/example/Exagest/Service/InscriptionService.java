package com.example.Exagest.Service;

import com.example.Exagest.entities.Inscription;

import java.util.List;

public interface InscriptionService {
   Inscription addinscription(Inscription inscription);
    Inscription editinscriptionn( Long id);
    String deleteinscription(Long id);
    List<Inscription> listinscription();
}
