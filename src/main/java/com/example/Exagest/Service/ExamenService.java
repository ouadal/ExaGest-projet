package com.example.Exagest.Service;

import com.example.Exagest.entities.Examen;
import com.example.Exagest.requests.EnrolementRequestModel;

import java.util.List;

public interface ExamenService {
    Examen addexamen(EnrolementRequestModel enrolementRequestModel);
    Examen editexamen( Long id,Examen examen);
    String deleteexamen(Long id);
    List<Examen> listEcol();

    List<Examen> listAnnee();

    List<Examen> listExameLib();


    Examen findByIdOfExam(Long id);
}
