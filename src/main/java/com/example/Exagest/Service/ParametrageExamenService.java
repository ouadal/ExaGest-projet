package com.example.Exagest.Service;

import com.example.Exagest.entities.ParametrageExam;

import java.util.List;

public interface ParametrageExamenService {
    ParametrageExam addparamExam(ParametrageExam parametrageExam);
    ParametrageExam editparamExam( Long id);
    String deleteparamExam(Long id);
    List<ParametrageExam> listparamExam();
}
