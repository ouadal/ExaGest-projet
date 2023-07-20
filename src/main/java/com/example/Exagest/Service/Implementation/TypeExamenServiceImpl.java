package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.TypeExamenService;
import com.example.Exagest.entities.TypeExamen;
import com.example.Exagest.entities.TypeMat;
import com.example.Exagest.repository.TypeExamenRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class TypeExamenServiceImpl implements TypeExamenService {
    private final TypeExamenRepository typeExamenRepository;

    public TypeExamenServiceImpl(TypeExamenRepository typeExamenRepository) {
        this.typeExamenRepository = typeExamenRepository;
    }

    @Override
    public TypeExamen addtypeExamen(TypeExamen typeExamen) {
        typeExamen.setAddDate(LocalDate.now());
        return typeExamenRepository.save(typeExamen);
    }

    @Override
    public TypeExamen edittypeExamen(Long id,TypeExamen typeExamen) {
        Optional<TypeExamen> optionalTypeExamen =typeExamenRepository.findById(id);
        if(optionalTypeExamen.isEmpty()){
            System.out.println("TypeExamen modifié avec succès");
        }
        TypeExamen dbTypeExamen = optionalTypeExamen.get();
        dbTypeExamen.setUpdateDate(LocalDate.now());
        dbTypeExamen.setLibele(typeExamen.getLibele());
        return typeExamenRepository.save(dbTypeExamen);

    }

    @Override
    public String deletetypeExamen(Long id) {
        typeExamenRepository.deleteById(id);
        return "typeExamen supprimer avec succès";
    }

    @Override
    public List<TypeExamen> listtypeExamLib() {
        return typeExamenRepository.listtypeExamLib();
    }



    @Override
    public TypeExamen choisirTypeExamen() {
        return null;
    }

    @Override
    public TypeExamen findByIdOfTypEx(Long id) {
        return typeExamenRepository.findById(id).orElseThrow();
    }
}
