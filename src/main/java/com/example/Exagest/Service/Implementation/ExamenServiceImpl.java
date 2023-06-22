package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.ExamenService;
import com.example.Exagest.entities.Examen;
import com.example.Exagest.repository.ExamenRepository;

import java.util.List;

public class ExamenServiceImpl implements ExamenService {
    private final ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public Examen addexamen(Examen examen) {
        return null;
    }

    @Override
    public Examen editexamen(Long id) {
        return null;
    }

    @Override
    public String deleteexamen(Long id) {
        return null;
    }

    @Override
    public List<Examen> listexamen() {
        return null;
    }
}
