package com.example.Exagest.Service;

import com.example.Exagest.entities.Examen;

import java.util.List;

public interface ExamenService {
    Examen addexamen(Examen examen);
    Examen editexamen( Long id);
    String deleteexamen(Long id);
    List<Examen> listexamen();
}
