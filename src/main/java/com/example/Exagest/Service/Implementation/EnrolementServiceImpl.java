package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.EnrolementService;
import com.example.Exagest.entities.Enrolement;
import com.example.Exagest.entities.Periode;
import com.example.Exagest.repository.EnrolementRepository;

import java.util.List;
import java.util.Optional;

public class EnrolementServiceImpl implements EnrolementService {
    private final EnrolementRepository enrolementRepository;

    public EnrolementServiceImpl(EnrolementRepository enrolementRepository) {
        this.enrolementRepository = enrolementRepository;
    }

    @Override
    public Enrolement addenrolement(Enrolement enrolement) {
        return enrolementRepository.save(enrolement);
    }

    @Override
    public Enrolement editenrolement(Long id,Enrolement enrolement) {
        Optional<Enrolement> optionalEnrolement =enrolementRepository.findById(id);
        if(optionalEnrolement.isEmpty()){
            System.out.println("Enrolement modifié avec succès");
        }
        Enrolement dbEnrolement = optionalEnrolement.get();
        dbEnrolement.setDateAjout(enrolement.getDateAjout());
        dbEnrolement.setDateEnrolement(enrolement.getDateEnrolement());
        dbEnrolement.setDateModife(enrolement.getDateModife());
        dbEnrolement.setInscription(enrolement.getInscription());
        return enrolementRepository.save(dbEnrolement);
    }

    @Override
    public String deleteenrolement(Long id) {
        enrolementRepository.deleteById(id);
        return "Enrolement supprimé avec succès";
    }

    @Override
    public List<Enrolement> listenrolement() {
        return enrolementRepository.findAll();
    }
}
