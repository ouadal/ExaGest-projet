package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.EleveService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Ecole;
import com.example.Exagest.entities.Eleve;
import com.example.Exagest.entities.Enrolement;
import com.example.Exagest.repository.AnneeRepository;
import com.example.Exagest.repository.EcoleRepository;
import com.example.Exagest.repository.EleveRepository;
import com.example.Exagest.repository.InscriptionRepository;
import com.example.Exagest.requests.InscriptionRequestModel;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class EleveServiceImpl implements EleveService {
    private final EleveRepository eleveRepository;

    private final AnneeRepository anneeRepository;

    private final InscriptionRepository inscriptionRepository;

    private final EcoleRepository ecoleRepository;

    public EleveServiceImpl(EleveRepository eleveRepository, AnneeRepository anneeRepository, InscriptionRepository inscriptionRepository, EcoleRepository ecoleRepository) {
        this.eleveRepository = eleveRepository;
        this.anneeRepository = anneeRepository;
        this.inscriptionRepository = inscriptionRepository;
        this.ecoleRepository = ecoleRepository;
    }

    @Override
    public Eleve addeleve(InscriptionRequestModel inscriptionRequestModel) {
        Eleve eleve1 = new Eleve();
        Annee a = anneeRepository.getCurrentYear();

        eleve1.setUpdateDate(null);
        eleve1.setAddDate(LocalDate.now());
        eleve1.setNom(inscriptionRM.getNom());
        eleve1.setPrenom(inscriptionRM.getPrenom());
        eleve1.setContactParent(inscriptionRM.getContactParent());
        eleve1.setDate_naissance(inscriptionRM.getDate_naissance());

        eleve1 = eleveRepository.save(eleve);


        Optional<Ecole> el = ecoleRepository.findById(inscriptionRM.getIdEcole());
        //Optional<Annee> an = anneeRepository.findById(inscription.getAnnee().getId());
        Optional<Enrolement> en = enrolementRepository.findById(inscriptionRM.getIdEnrolement());
        //Optional<Eleve> ev = eleveRepository.findById(inscription.getEleve().getId());
//        System.out.println(el.isPresent());
//        System.out.println(an.isPresent());
//        System.out.println(ex.isPresent());
        if (el.isPresent()  && en.isPresent()) {
            inscription.setEcole(el.get());
            inscription.setEnrolement(en.get());
            inscription.setEleve(eleveSaved);
            return inscriptionRepository.save(inscription);
        }
        return inscription;        return eleveRepository.save(eleve);
    }

    @Override
    public Eleve editeleve(Long id,Eleve eleve) {
        Optional<Eleve> optionalEleve = eleveRepository.findById(id);
        if(optionalEleve.isEmpty()){
            System.out.println("Eleve modifié avec succès");
        }
       Eleve dbEleve = optionalEleve.get();
        dbEleve.setUpdateDate(LocalDate.now());
        dbEleve.setContactParent(eleve.getContactParent());
        dbEleve.setNom(eleve.getNom());
        dbEleve.setDate_naissance(eleve.getDate_naissance());
        dbEleve.setPrenom(eleve.getPrenom());

        return eleveRepository.save(dbEleve);
    }

    @Override
    public String deleteeleve(Long id) {
        eleveRepository.deleteById(id);
        return "Eleve supprimer avec succès";
    }

    @Override
    public List<Eleve> listNom() {
        return eleveRepository.listNom();
    }

    @Override
    public List<Eleve> listElevMat(Long id) {
        return eleveRepository.listElevMat(id);
    }


}
