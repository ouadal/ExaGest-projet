package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.CycleTypeExamenService;
import com.example.Exagest.entities.CycleTypeExamen;
import com.example.Exagest.repository.CycleTypeExamenRepository;

import java.util.List;

public class CycleTypeExamenServiceImpl implements CycleTypeExamenService {
    private final CycleTypeExamenRepository cycleTypeExamenRepository;

    public CycleTypeExamenServiceImpl(CycleTypeExamenRepository cycleTypeExamenRepository) {
        this.cycleTypeExamenRepository = cycleTypeExamenRepository;
    }

    @Override
    public CycleTypeExamen addcycleTypeExam(CycleTypeExamen cycleTypeExamen) {
        return null;
    }

    @Override
    public CycleTypeExamen editcycleTypeExam(Long id) {
        return null;
    }

    @Override
    public String deletecycleTypeExam(Long id) {
        return null;
    }

    @Override
    public List<CycleTypeExamen> listcycleTypeExam() {
        return null;
    }
}
