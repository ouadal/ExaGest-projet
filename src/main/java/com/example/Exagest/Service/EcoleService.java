package com.example.Exagest.Service;

import com.example.Exagest.entities.Ecole;

import java.util.List;

public interface EcoleService {
    Ecole addecole(Ecole ecole);
    Ecole editecole( Long id);
    String deleteecole(Long id);
    List<Ecole> listecole();
}
