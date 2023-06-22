package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.EleveService;
import com.example.Exagest.entities.Eleve;
import com.example.Exagest.repository.EleveRepository;

import java.util.List;

public class EleveServiceImpl implements EleveService {
    private final EleveRepository eleveRepository;

    public EleveServiceImpl(EleveRepository eleveRepository) {
        this.eleveRepository = eleveRepository;
    }

    @Override
    public Eleve addeleve(Eleve eleve) {
        return null;
    }

    @Override
    public Eleve editeleve(Long id) {
        return null;
    }

    @Override
    public String deleteeleve(Long id) {
        return null;
    }

    @Override
    public List<Eleve> listeleve() {
        return null;
    }
}
