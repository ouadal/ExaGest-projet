package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.CycleTypeExamenService;
import com.example.Exagest.entities.CycleTypeExamen;
import com.example.Exagest.entities.Eleve;
import com.example.Exagest.repository.CycleTypeExamenRepository;

import java.util.List;
import java.util.Optional;

public class CycleTypeExamenServiceImpl implements CycleTypeExamenService {
    private final CycleTypeExamenRepository cycleTypeExamenRepository;

    public CycleTypeExamenServiceImpl(CycleTypeExamenRepository cycleTypeExamenRepository) {
        this.cycleTypeExamenRepository = cycleTypeExamenRepository;
    }

    @Override
    public CycleTypeExamen addcycleTypeExam(CycleTypeExamen cycleTypeExamen) {
        return cycleTypeExamenRepository.save(cycleTypeExamen);
    }

    @Override
    public CycleTypeExamen editcycleTypeExam(Long id,CycleTypeExamen cycleTypeExamen) {
        Optional<CycleTypeExamen> optionalCycleTypeExamen = cycleTypeExamenRepository.findById(id);
        if(optionalCycleTypeExamen.isEmpty()){
            System.out.println("CycleTypeExamen modifié avec succès");
        }
        CycleTypeExamen dbCycleTypeExamen= optionalCycleTypeExamen.get();
        dbCycleTypeExamen.setTypeExamen(cycleTypeExamen.getTypeExamen());
        dbCycleTypeExamen.setCycle(cycleTypeExamen.getCycle());
        return cycleTypeExamenRepository.save(dbCycleTypeExamen);
    }

    @Override
    public String deletecycleTypeExam(Long id) {
        cycleTypeExamenRepository.deleteById(id);
        return "CycleTypeExamen supprimé avec succès";
    }

    @Override
    public List<CycleTypeExamen> listcycleTypeExam() {
        return cycleTypeExamenRepository.findAll();
    }
}
