package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.TypeMatService;
import com.example.Exagest.entities.TypeMat;
import com.example.Exagest.repository.TypeMatRepository;

import java.util.List;
import java.util.Optional;

public class TypeMatServiceImpl implements TypeMatService {
    private final TypeMatRepository typeMatRepository;

    public TypeMatServiceImpl(TypeMatRepository typeMatRepository) {
        this.typeMatRepository = typeMatRepository;
    }

    @Override
    public TypeMat addtypeMat(TypeMat typeMat) {
        return typeMatRepository.save(typeMat);
    }

    @Override
    public TypeMat edittypeMat(Long id,TypeMat typeMat) {
        Optional<TypeMat> optionalTypeMat =typeMatRepository.findById(id);
        if(optionalTypeMat.isEmpty()){
            System.out.println("TypeMatiere modifié avec succès");
        }
        TypeMat dbTypeMat = optionalTypeMat.get();
        dbTypeMat.setDateAjout(typeMat.getDateAjout());
        dbTypeMat.setMatiere(typeMat.getMatiere());
        dbTypeMat.setDateModife(typeMat.getDateModife());
        return typeMatRepository.save(dbTypeMat);

    }

    @Override
    public String deletetypeMat(Long id) {
        typeMatRepository.deleteById(id);
        return "typeMatiere supprimé avec succès";
    }

    @Override
    public List<TypeMat> listtypeMat() {
        return typeMatRepository.findAll();
    }
}
