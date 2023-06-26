package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.EleveService;
import com.example.Exagest.entities.Eleve;
import com.example.Exagest.repository.EleveRepository;

import java.util.List;
import java.util.Optional;

public class EleveServiceImpl implements EleveService {
    private final EleveRepository eleveRepository;

    public EleveServiceImpl(EleveRepository eleveRepository) {
        this.eleveRepository = eleveRepository;
    }

    @Override
    public Eleve addeleve(Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    @Override
    public Eleve editeleve(Long id,Eleve eleve) {
        Optional<Eleve> optionalEleve = eleveRepository.findById(id);
        if(optionalEleve.isEmpty()){
            System.out.println("Eleve modifié avec succès");
        }
       Eleve dbEleve = optionalEleve.get();

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


}
