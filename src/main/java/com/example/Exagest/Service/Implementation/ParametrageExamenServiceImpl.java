package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.ParametrageExamenService;
import com.example.Exagest.entities.ParametrageExam;
import com.example.Exagest.repository.ParametrageExamRepository;

import java.util.List;

public class ParametrageExamenServiceImpl implements ParametrageExamenService{
    private final ParametrageExamRepository parametrageExamRepository;

    public ParametrageExamenServiceImpl(ParametrageExamRepository parametrageExamRepository) {
        this.parametrageExamRepository = parametrageExamRepository;
    }

    @Override
    public ParametrageExam addparamExam(ParametrageExam parametrageExam) {
        return null;
    }

    @Override
    public ParametrageExam editparamExam(Long id,ParametrageExam parametrageExam) {
        return null;
    }

    @Override
    public String deleteparamExam(Long id) {
        return null;
    }

    @Override
    public List<ParametrageExam> listparamExam() {
        return null;
    }
}
