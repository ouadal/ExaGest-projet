package com.example.Exagest.Service;

import com.example.Exagest.entities.ParamMatiere;
import com.example.Exagest.entities.ParametrageExam;
import com.example.Exagest.entities.Section;

import java.util.List;

public interface ParamMatiereService {
    ParamMatiere addparamMatiere(ParamMatiere paramMatiere);
    ParamMatiere editparamMatiere(Long id, ParamMatiere paramMatiere);
    String deleteparamMatiere(Long id);
    List<ParamMatiere> listparamMatiere();
}
