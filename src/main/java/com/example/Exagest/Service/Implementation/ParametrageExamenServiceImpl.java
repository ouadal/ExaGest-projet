package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.ParametrageExamenService;
import com.example.Exagest.entities.ParametrageExam;
import com.example.Exagest.entities.Periode;
import com.example.Exagest.repository.ParametrageExamRepository;

import java.util.List;
import java.util.Optional;

public class ParametrageExamenServiceImpl implements ParametrageExamenService{
    private final ParametrageExamRepository parametrageExamRepository;

    public ParametrageExamenServiceImpl(ParametrageExamRepository parametrageExamRepository) {
        this.parametrageExamRepository = parametrageExamRepository;
    }

    @Override
    public ParametrageExam addparamExam(ParametrageExam parametrageExam) {
        return parametrageExamRepository.save(parametrageExam);
    }

    @Override
    public ParametrageExam editparamExam(Long id,ParametrageExam parametrageExam) {
        Optional<ParametrageExam> optionalParametrageExam =parametrageExamRepository.findById(id);
        if(optionalParametrageExam.isEmpty()){
            System.out.println("ParametrageExamen modifié avec succès");
        }
        ParametrageExam dbParametrageExamen = optionalParametrageExam.get();
        dbParametrageExamen.setDateAjout(parametrageExam.getDateAjout());
        dbParametrageExamen.setEtat(parametrageExam.isEtat());
        dbParametrageExamen.setDateModife(parametrageExam.getDateModife());
        return parametrageExamRepository.save(dbParametrageExamen);
    }

    @Override
    public String deleteparamExam(Long id) {
        parametrageExamRepository.deleteById(id);
        return "parametrageExamen supprimer avec succès";
    }

    @Override
    public List<ParametrageExam> listparamExam() {
        return parametrageExamRepository.findAll();
    }
}
