package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.TypeExamenService;
import com.example.Exagest.entities.TypeExamen;
import com.example.Exagest.repository.TypeExamenRepository;

import java.util.List;

public class TypeExamenServiceImpl implements TypeExamenService {
    private final TypeExamenRepository typeExamenRepository;

    public TypeExamenServiceImpl(TypeExamenRepository typeExamenRepository) {
        this.typeExamenRepository = typeExamenRepository;
    }

    @Override
    public TypeExamen addtypeExamen(TypeExamen typeExamen) {
        return null;
    }

    @Override
    public TypeExamen edittypeExamen(Long id) {
        return null;
    }

    @Override
    public String deletetypeExamen(Long id) {
        return null;
    }

    @Override
    public List<TypeExamen> listtypeExamen() {
        return null;
    }
}
