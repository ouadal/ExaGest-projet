package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.ExamenService;
import com.example.Exagest.entities.Examen;
import com.example.Exagest.entities.Periode;
import com.example.Exagest.repository.ExamenRepository;

import java.util.List;
import java.util.Optional;

public class ExamenServiceImpl implements ExamenService {
    private final ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public Examen addexamen(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Examen editexamen(Long id,Examen examen) {
        Optional<Examen> optionalExamen =examenRepository.findById(id);
        if(optionalExamen.isEmpty()){
            System.out.println("Examen modifié avec succès");
        }
        Examen dbExamen = optionalExamen.get();
        dbExamen.setDateAjout(examen.getDateAjout());
        dbExamen.setCycleTypeExamen(examen.getCycleTypeExamen());
        dbExamen.setEleve(examen.getEleve());
        dbExamen.setEnrolement(examen.getEnrolement());
        dbExamen.setParametrageExam(examen.getParametrageExam());
        dbExamen.setStatut(examen.isStatut());
        return examenRepository.save(dbExamen);
    }

    @Override
    public String deleteexamen(Long id) {
        examenRepository.deleteById(id);
        return "Examen supprimé avec succès";
    }

    @Override
    public List<Examen> listexamen() {
        return examenRepository.findAll();
    }
}
