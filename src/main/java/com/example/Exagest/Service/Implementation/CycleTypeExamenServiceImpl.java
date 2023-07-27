package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.CycleTypeExamenService;
import com.example.Exagest.entities.Cycle;
import com.example.Exagest.entities.CycleTypeExamen;
import com.example.Exagest.entities.TypeExamen;
import com.example.Exagest.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class CycleTypeExamenServiceImpl implements CycleTypeExamenService {
    private final CycleTypeExamenRepository cycleTypeExamenRepository;

  private final TypeExamenRepository typeExamenRepository;

private final CycleRepository cycleRepository;

    public CycleTypeExamenServiceImpl(CycleTypeExamenRepository cycleTypeExamenRepository, TypeExamenRepository typeExamenRepository, AnneeRepository anneeRepository, CycleRepository cycleRepository) {
        this.cycleTypeExamenRepository = cycleTypeExamenRepository;
        this.typeExamenRepository = typeExamenRepository;
        this.cycleRepository = cycleRepository;


    }

    @Override
    public CycleTypeExamen addcycleTypeExam(CycleTypeExamen cycleTypeExamen) {
        cycleTypeExamen.setAddDate(LocalDate.now());
        Optional<TypeExamen> te = typeExamenRepository.findById(cycleTypeExamen.getTypeExamen().getId());
        Optional<Cycle> cy = cycleRepository.findById(cycleTypeExamen.getCycle().getId());
        if (te.isPresent() && cy.isPresent()){
            cycleTypeExamen.setCycle(cy.get());
            cycleTypeExamen.setTypeExamen(te.get());
            return cycleTypeExamenRepository.save(cycleTypeExamen);
        }
        return null;
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
        dbCycleTypeExamen.setUpdateDate(LocalDate.now());
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

    @Override
    public CycleTypeExamen findByIdOfCycTyp(Long id) {
        return cycleTypeExamenRepository.findById(id).orElseThrow();
    }

    @Override
    public List<CycleTypeExamen> listtypeExamenPerCycle(Long idEcole) {
        Cycle cycle = cycleRepository.cycleEnFonctDeEcol(idEcole);
        return cycleTypeExamenRepository.listtypeExamenPerCycle(cycle.getId());
    }


}
