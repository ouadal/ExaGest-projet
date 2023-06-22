package com.example.Exagest.Service;

import com.example.Exagest.entities.Moyenne;

import java.util.List;

public interface MoyenneService {
    Moyenne addmoyenne(Moyenne moyenne);
    Moyenne editmoyenne( Long id,Moyenne moyenne);
    String deletemoyenne(Long id);
    List<Moyenne> listmoyenne();
}
