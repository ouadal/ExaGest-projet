package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.CycleService;
import com.example.Exagest.entities.Cycle;
import com.example.Exagest.repository.CycleRepository;

import java.util.List;

public class CycleServiceImpl implements CycleService {
    private final CycleRepository cycleRepository;

    public CycleServiceImpl(CycleRepository cycleRepository) {
        this.cycleRepository = cycleRepository;
    }

    @Override
    public Cycle addcycle(Cycle cycle) {
        return null;
    }

    @Override
    public Cycle editcycle(Long id) {
        return null;
    }

    @Override
    public String deletecycle(Long id) {
        return null;
    }

    @Override
    public List<Cycle> listcycle() {
        return null;
    }
}
