package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.repository.InscriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class InscriptionServiceImpl implements InscriptionService {
    private final InscriptionRepository inscriptionRepository;

    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public Inscription addinscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription editinscriptionn(Long id,Inscription inscription) {
        Optional<Inscription> optionalInscription =inscriptionRepository.findById(id);
        if(optionalInscription.isEmpty()){
            System.out.println("Inscription modifié avec succès");
        }
        Inscription dbInscription = optionalInscription.get();
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
