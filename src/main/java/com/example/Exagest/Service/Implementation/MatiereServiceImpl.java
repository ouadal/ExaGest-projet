package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.MatiereService;
import com.example.Exagest.entities.Matiere;
import com.example.Exagest.entities.Periode;
import com.example.Exagest.repository.MatiereRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatiereServiceImpl implements MatiereService {
    private final MatiereRepository matiereRepository;

    public MatiereServiceImpl(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }

    @Override
    public Matiere addmatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    @Override
    public Matiere editmatiere(Long id,Matiere matiere) {
        Optional<Matiere> optionalMatiere =matiereRepository.findById(id);
        if(optionalMatiere.isEmpty()){
            System.out.println("Matière modifié avec succès");
        }
        Matiere dbMatiere = optionalMatiere.get();
        dbMatiere.setDateAjout(matiere.getDateAjout());
        dbMatiere.setLibelleMat(matiere.getLibelleMat());
        dbMatiere.setDateModife(matiere.getDateModife());
        dbMatiere.setCodeMat(matiere.getCodeMat());
        dbMatiere.setParametrageExam(matiere.getParametrageExam());
        return matiereRepository.save(dbMatiere);
    }

    @Override
    public String deletematiere(Long id) {
         matiereRepository.deleteById(id);
         return "Matière supprimer avec succès";
    }

    @Override
    public List<Matiere> listmatiere() {
        return matiereRepository.findAll();
    }
}
