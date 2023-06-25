package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.MoyenneService;
import com.example.Exagest.entities.Moyenne;
import com.example.Exagest.repository.MoyenneRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MoyenneServiceImpl implements MoyenneService {
    private final MoyenneRepository moyenneRepository;

    public MoyenneServiceImpl(MoyenneRepository moyenneRepository) {
        this.moyenneRepository = moyenneRepository;
    }

    @Override
    public Moyenne addmoyenne(Moyenne moyenne) {
        return moyenneRepository.save(moyenne);
    }

    @Override
    public Moyenne editmoyenne(Long id,Moyenne moyenne) {
          Optional<Moyenne> optionalMoyenne =moyenneRepository.findById(id);
        if(optionalMoyenne.isEmpty()){
            System.out.println("Moyenne modifié avec succès");
        }
        Moyenne dbMoyenne= optionalMoyenne.get();
        dbMoyenne.setDateAjout(moyenne.getDateAjout());
        dbMoyenne.setLibelleMoy(moyenne.getLibelleMoy());
        dbMoyenne.setDateModife(moyenne.getDateModife());
        return moyenneRepository.save(dbMoyenne);
    }

    @Override
    public String deletemoyenne(Long id) {
        moyenneRepository.deleteById(id);
        return "Moyenne supprimer avec succès";
    }

    @Override
    public List<Moyenne> listmoyenne() {
        return moyenneRepository.findAll();
    }
}
