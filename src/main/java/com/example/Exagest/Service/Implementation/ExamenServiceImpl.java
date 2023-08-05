package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.ExamenService;
import com.example.Exagest.entities.*;
import com.example.Exagest.repository.*;
import com.example.Exagest.requests.EnrolementRequestModel;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class ExamenServiceImpl implements ExamenService {
    private final ExamenRepository examenRepository;
    private final AnneeRepository anneeRepository;

    private final EcoleRepository ecoleRepository;

    private final EnrolementRepository enrolementRepository;

    private final CycleTypeExamenRepository cycleTypeExamenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository, AnneeRepository anneeRepository, EcoleRepository ecoleRepository, EnrolementRepository enrolementRepository, CycleTypeExamenRepository cycleTypeExamenRepository) {
        this.examenRepository = examenRepository;
        this.anneeRepository = anneeRepository;
        this.ecoleRepository = ecoleRepository;
        this.enrolementRepository = enrolementRepository;
        this.cycleTypeExamenRepository = cycleTypeExamenRepository;
    }

    @Override
    public Examen addexamen(EnrolementRequestModel enrolementRequestModel) {

        Examen examen1 = new Examen();
        Enrolement enrolement = new Enrolement();

        Annee a = anneeRepository.getCurrentYear();
        Optional<CycleTypeExamen> ctex = cycleTypeExamenRepository.findById(enrolementRequestModel.getIdCycleTypeExamen());
        Optional<Ecole> el = ecoleRepository.findById(enrolementRequestModel.getIdEcole());
        ctex.ifPresent(examen1::setCycleTypeExamen);

        el.ifPresent(examen1::setEcole);

        examen1.setAnnee(a);
        examen1.setAddDate(LocalDate.now());
        examen1.setLibele(enrolementRequestModel.getLibele());
        examen1.setStatut(enrolementRequestModel.isStatut());




        Examen examenSaved  = examenRepository.save(examen1);

        System.out.println(examenSaved.getId());
        System.out.println(enrolementRequestModel.getIdEcole());

        Optional<Examen> ex = examenRepository.findById(examenSaved.getId());




        if (el.isPresent() && ex.isPresent()){

            enrolement.setExamen(ex.get());
            enrolement.setEcole(el.get());
            enrolement.setExamen(examenSaved);
            enrolement.setUpdateDate(null);
            enrolement.setAddDate(LocalDate.now());

            return enrolementRepository.save(enrolement).getExamen() ;
        }
        return examenSaved;
    }

    @Override
    public Examen editexamen(Long id,Examen examen) {
        Optional<Examen> optionalExamen =examenRepository.findById(id);
        if(optionalExamen.isEmpty()){
            System.out.println("Examen modifié avec succès");
        }
        Examen dbExamen = optionalExamen.get();
        dbExamen.setUpdateDate(LocalDate.now());
        dbExamen.setEcole(examen.getEcole());
        dbExamen.setAnnee(examen.getAnnee());
        dbExamen.setLibele(examen.getLibele());
        dbExamen.setCycleTypeExamen(examen.getCycleTypeExamen());
        dbExamen.setStatut(examen.isStatut());
        return examenRepository.save(dbExamen);
    }

    @Override
    public String deleteexamen(Long id) {
        examenRepository.deleteById(id);
        return "Examen supprimé avec succès";
    }

    @Override
    public List<Examen> listEcol() {
        return examenRepository.listEcol();
    }

    @Override
    public List<Examen> listAnnee() {
        return examenRepository.listAnnee();
    }

    @Override
    public List<Examen> listExameLib() {
        return examenRepository.listExameLib();
    }

    @Override
    public Examen findByIdOfExam(Long id) {
        return examenRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Examen> listExamPerEcol(Long id) {
        return examenRepository.listExamPerEcol(id);
    }

    @Override
    public boolean setCurrentExamToActif(Long idExamen, Long idEcol) {
        Optional<Examen> ex = examenRepository.findById(idExamen);
        Annee annee = anneeRepository.getCurrentYear();
        if (ex.isPresent()) {
            examenRepository.setToFalseAllExamDiffOf(idExamen, idEcol,annee.getId());
            ex.get().setStatut(true);
            examenRepository.save(ex.get());
            return true;
        }
        return false;

    }

    @Override
    public Examen setExamFalse(Long id) {
        Optional <Examen>  ex=  examenRepository.findById(id);
        if(ex.isPresent()){
           examenRepository.setExamFalse(id);
            return  examenRepository.save(ex.get());
        }
        return null;


    }

    @Override
    public List<Examen> listExamAucoursDuneAnee(Long idEcol) {
        return examenRepository.listExamAucoursDuneAnee(idEcol);
    }

//

}
