package com.example.Exagest.Service;

import com.example.Exagest.entities.TypeExamen;

import java.util.List;

public interface TypeExamenService {
    TypeExamen addtypeExamen(TypeExamen typeExamen);

    TypeExamen edittypeExamen( Long id,TypeExamen typeExamen);

    String deletetypeExamen(Long id);

    List<TypeExamen> listtypeExamLib();

    TypeExamen choisirTypeExamen();

    TypeExamen findByIdOfTypEx(Long id);
}
