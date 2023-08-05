package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.EnrolementService;
import com.example.Exagest.entities.Ecole;
import com.example.Exagest.entities.Enrolement;
import com.example.Exagest.entities.Examen;
import com.example.Exagest.repository.EcoleRepository;
import com.example.Exagest.repository.EnrolementRepository;
import com.example.Exagest.repository.ExamenRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class EnrolementServiceImpl implements EnrolementService {
    private final EnrolementRepository enrolementRepository;
    private final ExamenRepository examenRepository;

    private EcoleRepository ecoleRepository;

    public EnrolementServiceImpl(EnrolementRepository enrolementRepository, ExamenRepository examenRepository, EcoleRepository ecoleRepository) {
        this.enrolementRepository = enrolementRepository;
        this.examenRepository = examenRepository;
        this.ecoleRepository = ecoleRepository;
    }

    @Override
    public Enrolement addenrolement(Enrolement enrolement) {
        enrolement.setAddDate(LocalDate.now());
        Optional<Examen> ex = examenRepository.findById(enrolement.getExamen().getId());
        Optional<Ecole> el = ecoleRepository.findById(enrolement.getEcole().getId());
        if (ex.isPresent()&& el.isPresent()){
         enrolement.setEcole(el.get());
            enrolement.setExamen(ex.get());

            return enrolementRepository.save(enrolement);
        }
        return enrolement;
    }

    @Override
    public Enrolement editenrolement(Long id,Enrolement enrolement) {
        Optional<Enrolement> optionalEnrolement =enrolementRepository.findById(id);
        if(optionalEnrolement.isEmpty()){
            System.out.println("Enrolement modifié avec succès");
        }
        Enrolement dbEnrolement = optionalEnrolement.get();
        dbEnrolement.setUpdateDate(LocalDate.now());
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

    @Override
    public Enrolement findByIdOfEnrol(Long id) {
        return enrolementRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Enrolement> getAllEnrollementsByEcol(Long idEcole) {
        return enrolementRepository.getAllEnrollementsByEcol(idEcole);
    }
    @Override
    public List<Enrolement> getAllEcolThatAreEnrolled(Long idExamen) {
        return enrolementRepository.getAllEcolThatAreEnrolled(idExamen);
    }
}
