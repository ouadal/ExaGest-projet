package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.MatiereService;
import com.example.Exagest.entities.Matiere;
import com.example.Exagest.entities.TypeMat;
import com.example.Exagest.repository.MatiereRepository;
import com.example.Exagest.repository.TypeMatRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatiereServiceImpl implements MatiereService {
    private final MatiereRepository matiereRepository;
    private final TypeMatRepository typeMatRepository;

    public MatiereServiceImpl(MatiereRepository matiereRepository, TypeMatRepository typeMatRepository) {
        this.matiereRepository = matiereRepository;
        this.typeMatRepository = typeMatRepository;
    }

    @Override
    public Matiere addmatiere(Matiere matiere) {
        matiere.setAddDate(LocalDate.now());
         Optional<TypeMat> tm = typeMatRepository.findById(matiere.getTypeMat().getId());
         if (tm.isPresent()){
             matiere.setTypeMat(tm.get());
             return matiereRepository.save(matiere);
         }
         return null;

    }

    @Override
    public Matiere editmatiere(Long id,Matiere matiere) {
        Optional<Matiere> optionalMatiere =matiereRepository.findById(id);
        if(optionalMatiere.isEmpty()){
            System.out.println("Matière modifié avec succès");
        }
        Matiere dbMatiere = optionalMatiere.get();
        dbMatiere.setUpdateDate(LocalDate.now());

        dbMatiere.setLibele(matiere.getLibele());

        dbMatiere.setCodeMat(matiere.getCodeMat());

        return matiereRepository.save(dbMatiere);
    }

    @Override
    public String deletematiere(Long id) {
         matiereRepository.deleteById(id);
         return "Matière supprimer avec succès";
    }

    @Override
    public List<Matiere> listMatLib() {
        return matiereRepository.listMatLib();
    }

    @Override
    public List<Matiere> listTypMat() {
        return matiereRepository.listTypMat();
    }


}
