package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.*;
import com.example.Exagest.repository.*;
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

    private final EnrolementRepository enrolementRepository;

    private final EleveRepository eleveRepository;

    private final EcoleRepository ecoleRepository;

    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository, AnneeRepository anneeRepository, EnrolementRepository enrolementRepository, EleveRepository eleveRepository, EcoleRepository ecoleRepository) {
        this.inscriptionRepository = inscriptionRepository;
        this.anneeRepository = anneeRepository;
        this.enrolementRepository = enrolementRepository;
        this.eleveRepository = eleveRepository;
        this.ecoleRepository = ecoleRepository;
    }

    @Override
    public Inscription addinscription(Inscription inscription) {

        Annee a = anneeRepository.getCurrentYear();
        inscription.setAnnee(a);
        inscription.setAddDate(LocalDate.now());
        Optional<Ecole> el = ecoleRepository.findById(inscription.getEcole().getId());
        Optional<Annee> an = anneeRepository.findById(inscription.getAnnee().getId());
        Optional<Enrolement> en = enrolementRepository.findById(inscription.getEnrolement().getId());
        Optional<Eleve> ev = eleveRepository.findById(inscription.getEleve().getId());
//        System.out.println(el.isPresent());
//        System.out.println(an.isPresent());
//        System.out.println(ex.isPresent());
        if (el.isPresent() && an.isPresent() && ev.isPresent() && en.isPresent()) {
            inscription.setAnnee(an.get());
            inscription.setEcole(el.get());
            inscription.setEleve(ev.get());
            inscription.setEnrolement(en.get());
            return inscriptionRepository.save(inscription);
        }
        return inscription;
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
