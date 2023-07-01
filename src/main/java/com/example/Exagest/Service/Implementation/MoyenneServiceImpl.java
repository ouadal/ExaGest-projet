package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.MoyenneService;
import com.example.Exagest.entities.Moyenne;
import com.example.Exagest.repository.MoyenneRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        moyenne.setAddDate(LocalDate.now());
        return moyenneRepository.save(moyenne);
    }

    @Override
    public Moyenne editmoyenne(Long id,Moyenne moyenne) {
          Optional<Moyenne> optionalMoyenne = moyenneRepository.findById(id);
        if(optionalMoyenne.isEmpty()){
            System.out.println("Moyenne modifié avec succès");
        }
        Moyenne dbMoyenne = optionalMoyenne.get();
        dbMoyenne.setUpdateDate(LocalDate.now());
        dbMoyenne.setExamen(moyenne.getExamen());
        dbMoyenne.setSession(moyenne.getSession());
        dbMoyenne.setInscription(moyenne.getInscription());
        return moyenneRepository.save(dbMoyenne);
    }

    @Override
    public String deletemoyenne(Long id) {
        moyenneRepository.deleteById(id);
        return "Moyenne supprimer avec succès";
    }

    @Override
    public List<Moyenne> listIns() {
        return moyenneRepository.listIns();
    }

    @Override
    public List<Moyenne> listExam() {
        return moyenneRepository.listExam();
    }

    @Override
    public List<Moyenne> listSess() {
        return moyenneRepository.listSess();
    }

}
