package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.MatiereService;
import com.example.Exagest.entities.Eleve;
import com.example.Exagest.entities.Matiere;
import com.example.Exagest.entities.TypeMat;
import com.example.Exagest.repository.EleveRepository;
import com.example.Exagest.repository.MatiereRepository;
import com.example.Exagest.repository.TypeMatRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.lang.management.LockInfo;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatiereServiceImpl implements MatiereService {
    private final MatiereRepository matiereRepository;
    private final TypeMatRepository typeMatRepository;

    private final EleveRepository eleveRepository;

    public MatiereServiceImpl(MatiereRepository matiereRepository, TypeMatRepository typeMatRepository, EleveRepository eleveRepository) {
        this.matiereRepository = matiereRepository;
        this.typeMatRepository = typeMatRepository;
        this.eleveRepository = eleveRepository;
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
    public String deleteMatiere(Long id) {
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





    @Override
    public HashMap<String, List<Eleve>> matPerElv() {

        var data = new HashMap<String , List<Eleve>>();
        var matieres = matiereRepository.listMatLib();
        for (var matiere : matieres) {
            data.put(matiere.getLibele(), eleveRepository.listElevMat(matiere.getId()));
        }

        return  data;
    }

    @Override
    public Matiere findByIdOfMat(Long id) {
        return matiereRepository.findById(id).orElseThrow();
    }


}
