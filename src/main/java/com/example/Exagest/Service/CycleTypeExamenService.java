package com.example.Exagest.Service;

import com.example.Exagest.entities.CycleTypeExamen;

import java.util.List;

public interface CycleTypeExamenService {
   CycleTypeExamen addcycleTypeExam(CycleTypeExamen cycleTypeExamen);
    CycleTypeExamen editcycleTypeExam( Long id,CycleTypeExamen cycleTypeExamen);
    String deletecycleTypeExam(Long id);
    List<CycleTypeExamen> listcycleTypeExam();

    CycleTypeExamen findByIdOfCycTyp(Long id);
}
