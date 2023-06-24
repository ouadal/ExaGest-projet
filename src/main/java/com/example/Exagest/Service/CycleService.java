package com.example.Exagest.Service;

import com.example.Exagest.entities.Cycle;
import com.example.Exagest.entities.CycleTypeExamen;

import java.util.List;

public interface CycleService {
    Cycle addcycle(Cycle cycle);
   Cycle editcycle( Long id,Cycle cycle);
    String deletecycle(Long id);
    List<Cycle> listcycle();
    Cycle choisirCycle();

}
