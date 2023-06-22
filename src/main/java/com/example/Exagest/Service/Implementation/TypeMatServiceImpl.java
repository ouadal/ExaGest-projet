package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.TypeMatService;
import com.example.Exagest.entities.TypeMat;
import com.example.Exagest.repository.TypeMatRepository;

import java.util.List;

public class TypeMatServiceImpl implements TypeMatService {
    private final TypeMatRepository typeMatRepository;

    public TypeMatServiceImpl(TypeMatRepository typeMatRepository) {
        this.typeMatRepository = typeMatRepository;
    }

    @Override
    public TypeMat addtypeMat(TypeMat typeMat) {
        return null;
    }

    @Override
    public TypeMat edittypeMat(Long id) {
        return null;
    }

    @Override
    public String deletetypeMat(Long id) {
        return null;
    }

    @Override
    public List<TypeMat> listtypeMat() {
        return null;
    }
}
