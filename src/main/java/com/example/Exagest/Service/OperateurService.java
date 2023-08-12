package com.example.Exagest.Service;

import com.example.Exagest.entities.Operateur;

public interface OperateurService {
    Operateur findByIdOfOp(Long id);

    Operateur addop(Operateur operateur);

    Operateur editop( Operateur operateur,Long id);

    String deleteop(Long id);
}

