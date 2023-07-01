package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.ExamenService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Examen;
import com.example.Exagest.repository.AnneeRepository;
import com.example.Exagest.repository.ExamenRepository;
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

    public ExamenServiceImpl(ExamenRepository examenRepository, AnneeRepository anneeRepository) {
        this.examenRepository = examenRepository;
        this.anneeRepository = anneeRepository;
    }

    @Override
    public Examen addexamen(Examen examen) {
        Examen e = examenRepository.save(examen);
        Annee a = anneeRepository.getCurrentYear();
        e.setAnnee(a);
        e.setAddDate(LocalDate.now());
        return examenRepository.save(e);
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

}
