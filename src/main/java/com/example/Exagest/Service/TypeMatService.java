package com.example.Exagest.Service;

import com.example.Exagest.entities.TypeMat;

import java.util.List;

public interface TypeMatService {
    TypeMat addtypeMat(TypeMat typeMat);

    TypeMat edittypeMat( Long id,TypeMat typeMat);

    String deletetypeMat(Long id);

    List<TypeMat> listtypeMatLib();
}

