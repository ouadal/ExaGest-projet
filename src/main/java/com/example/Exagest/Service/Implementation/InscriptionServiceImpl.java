package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.repository.AnneeRepository;
import com.example.Exagest.repository.InscriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class InscriptionServiceImpl implements InscriptionService {
    private final InscriptionRepository inscriptionRepository;
    private final AnneeRepository anneeRepository;

    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository, AnneeRepository anneeRepository) {
        this.inscriptionRepository = inscriptionRepository;
        this.anneeRepository = anneeRepository;
    }

    @Override
    public Inscription addinscription(Inscription inscription) {
        Inscription i = inscriptionRepository.save(inscription);
        Annee a = anneeRepository.getCurrentYear();
        i.setAnnee(a);
        i.setAddDate(LocalDate.now());
        return inscriptionRepository.save(i);
    }

    @Override
    public Inscription editinscriptionn(Long id,Inscription inscription) {
        Optional<Inscription> optionalInscription =inscriptionRepository.findById(id);
        if(optionalInscription.isEmpty()){
            System.out.println("Inscription modifié avec succès");
        }
        Inscription dbInscription = optionalInscription.get();
        dbInscription.setUpdateDate(LocalDate.now());
        dbInscription.setStatut(inscription.isStatut());
        dbInscription.setAnnee(inscription.getAnnee());
        dbInscription.setEleve(inscription.getEleve());
        dbInscription.setEnrolement(inscription.getEnrolement());
        return inscriptionRepository.save(dbInscription);
    }

    @Override
    public String deleteinscription(Long id) {
         inscriptionRepository.deleteById(id);
         return "Inscription supprimé avec succès";
    }

    @Override
    public List<Inscription> listEcol() {
        return inscriptionRepository.listEcol();
    }

    @Override
    public List<Inscription> listElev() {
        return inscriptionRepository.listElev();
    }

    @Override
    public List<Inscription> listAnn() {
        return inscriptionRepository.listAnn();
    }

    @Override
    public List<Inscription> listEnrol() {
        return inscriptionRepository.listEnrol();
    }



}
