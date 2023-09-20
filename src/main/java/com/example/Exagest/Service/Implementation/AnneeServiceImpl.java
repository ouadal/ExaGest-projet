package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.AnneeService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Eleve;
import com.example.Exagest.repository.AnneeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnneeServiceImpl implements AnneeService {
private final AnneeRepository anneeRepository;

    public AnneeServiceImpl(AnneeRepository anneeRepository) {
        this.anneeRepository = anneeRepository;
    }

    @Override
    public Annee addAnnee(Annee annee) {
        annee.setEtat(false);
        annee.setAddDate(LocalDate.now());
        System.out.println(annee.toString());
        return anneeRepository.save(annee);
    }

    @Override
    public Annee editAnnee(Long id,Annee annee) {
        Optional<Annee> optionalAnnee = anneeRepository.findById(id);
        if(optionalAnnee.isEmpty()){
            System.out.println("Annee modifié avec succès");
        }
        Annee dbAnnee = optionalAnnee.get();
        dbAnnee.setUpdateDate(LocalDate.now());
        dbAnnee.setDateDebutAcademique(annee.getDateDebutAcademique());
        dbAnnee.setDateFinAcademique(annee.getDateFinAcademique());
        return anneeRepository.save(dbAnnee);
    }
    @Override
    public String deleteAnnee(Long id) {
        anneeRepository.deleteById(id);
        return "Annee supprimé avec succès";
    }

    @Override
    public List<Annee> listAnne() {
        return anneeRepository.listAnnee();
    }

    @Override
    public Annee setCurrentYear(Long id) {
        Optional <Annee>  an=  anneeRepository.findById(id);
        if(an.isPresent()){
            anneeRepository.setCurrentYear();
            an.get().setEtat(true);
            return  anneeRepository.save(an.get());
        }
        return null;


    }

    @Override
    public Annee findByIdOfAYear(Long id) {
        return anneeRepository.findById(id).orElseThrow();
    }


    @Override
    public Annee getCurrentYear() {
        Annee annee = anneeRepository.getCurrentYear();
        return annee;

    }
}
