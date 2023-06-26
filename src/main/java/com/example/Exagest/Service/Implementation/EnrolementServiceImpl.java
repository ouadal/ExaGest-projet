package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.EnrolementService;
import com.example.Exagest.entities.Enrolement;
import com.example.Exagest.repository.EnrolementRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional

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
        dbEnrolement.setExamen(enrolement.getExamen());
        dbEnrolement.setEcole(enrolement.getEcole());
        return enrolementRepository.save(dbEnrolement);
    }

    @Override
    public String deleteenrolement(Long id) {
        enrolementRepository.deleteById(id);
        return "Enrolement supprimé avec succès";
    }

    @Override
    public List<Enrolement> listEcol() {
        return enrolementRepository.listEcol();
    }

    @Override
    public List<Enrolement> listExamen() {
        return enrolementRepository.listExamen();
    }

}
