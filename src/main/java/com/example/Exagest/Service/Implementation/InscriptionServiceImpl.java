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
        dbInscription.setDateAjout(inscription.getDateAjout());
        dbInscription.setNote(inscription.getNote());
        dbInscription.setDateModife(inscription.getDateModife());
        dbInscription.setStatut(inscription.isStatut());
        dbInscription.setDateEnrole(inscription.getDateEnrole());
        return inscriptionRepository.save(dbInscription);
    }

    @Override
    public String deleteinscription(Long id) {
         inscriptionRepository.deleteById(id);
         return "Inscription supprimé avec succès";
    }

    @Override
    public List<Inscription> listinscription() {
        return inscriptionRepository.findAll();
    }
}
