package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.ParamMatiereService;
import com.example.Exagest.entities.ParamMatiere;
import com.example.Exagest.entities.ParametrageExam;
import com.example.Exagest.repository.ParamMatiereRepository;

import java.util.List;
import java.util.Optional;

public class ParamMatiereServiceImpl implements ParamMatiereService {
    private final ParamMatiereRepository paramMatiereRepository;

    public ParamMatiereServiceImpl(ParamMatiereRepository paramMatiereRepository) {
        this.paramMatiereRepository = paramMatiereRepository;
    }

    @Override
    public ParamMatiere addparamMatiere(ParamMatiere paramMatiere) {
        return paramMatiereRepository.save(paramMatiere);
    }

    @Override
    public ParamMatiere editparamMatiere(Long id, ParamMatiere paramMatiere) {
        Optional<ParamMatiere> optionalParamMatiere =paramMatiereRepository.findById(id);
        if(optionalParamMatiere.isEmpty()){
            System.out.println("ParametrageMatière modifié avec succès");
        }
        ParamMatiere dbParamMatiere = optionalParamMatiere.get();
        dbParamMatiere.setDateAjout(paramMatiere.getDateAjout());
        dbParamMatiere.setEtat(paramMatiere.isEtat());
        dbParamMatiere.setDateModife(paramMatiere.getDateModife());
        dbParamMatiere.setCoefficient(paramMatiere.getCoefficient());
        dbParamMatiere.setMatiere(paramMatiere.getMatiere());
        dbParamMatiere.setExamen(paramMatiere.getExamen());
        dbParamMatiere.setNombreCredit(paramMatiere.getNombreCredit());
        return paramMatiereRepository.save(dbParamMatiere);
    }

    @Override
    public String deleteparamMatiere(Long id) {
        paramMatiereRepository.deleteById(id);
        return "ParametrageMatiere supprimer avec succès";
    }

    @Override
    public List<ParamMatiere> listparamMatiere() {
        return paramMatiereRepository.findAll();
    }
}
