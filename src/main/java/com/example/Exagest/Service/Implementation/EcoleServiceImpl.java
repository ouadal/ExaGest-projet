package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.EcoleService;
import com.example.Exagest.entities.Ecole;
import com.example.Exagest.repository.EcoleRepository;

import java.util.List;

public class EcoleServiceImpl implements EcoleService {
    private final EcoleRepository ecoleRepository;

    public EcoleServiceImpl(EcoleRepository ecoleRepository) {
        this.ecoleRepository = ecoleRepository;
    }

    @Override
    public Ecole addecole(Ecole ecole) {
        return null;
    }

    @Override
    public Ecole editecole(Long id) {
        return null;
    }

    @Override
    public String deleteecole(Long id) {
        return null;
    }

    @Override
    public List<Ecole> listecole() {
        return null;
    }
}