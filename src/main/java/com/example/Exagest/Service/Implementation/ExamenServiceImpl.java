package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.ExamenService;
import com.example.Exagest.entities.Examen;
import com.example.Exagest.repository.ExamenRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class ExamenServiceImpl implements ExamenService {
    private final ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public Examen addexamen(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Examen editexamen(Long id,Examen examen) {
        Optional<Examen> optionalExamen =examenRepository.findById(id);
        if(optionalExamen.isEmpty()){
            System.out.println("Examen modifié avec succès");
        }
        Examen dbExamen = optionalExamen.get();
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
