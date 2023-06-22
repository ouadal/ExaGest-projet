package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.CycleService;
import com.example.Exagest.entities.Cycle;
import com.example.Exagest.entities.Eleve;
import com.example.Exagest.repository.CycleRepository;

import java.util.List;
import java.util.Optional;

public class CycleServiceImpl implements CycleService {
    private final CycleRepository cycleRepository;

    public CycleServiceImpl(CycleRepository cycleRepository) {
        this.cycleRepository = cycleRepository;
    }

    @Override
    public Cycle addcycle(Cycle cycle) {
        return cycleRepository.save(cycle);
    }

    @Override
    public Cycle editcycle(Long id,Cycle cycle) {
        Optional<Cycle> optionalCycle = cycleRepository.findById(id);
        if(optionalCycle.isEmpty()){
            System.out.println("Cycle modifié avec succès");
        }
        Cycle dbCycle = optionalCycle.get();
        dbCycle.setDateAjout(cycle.getDateAjout());
        dbCycle.setLibelleCycle(cycle.getLibelleCycle());
        dbCycle.setCycleTypeExamen(cycle.getCycleTypeExamen());
        dbCycle.setTypeExamen(cycle.getTypeExamen());
        dbCycle.setDateModife(cycle.getDateModife());
        return cycleRepository.save(dbCycle);
    }

    @Override
    public String deletecycle(Long id) {
        cycleRepository.deleteById(id);
        return "Cycle supprimé avec succès";
    }

    @Override
    public List<Cycle> listcycle() {
        return cycleRepository.findAll();
    }
}
