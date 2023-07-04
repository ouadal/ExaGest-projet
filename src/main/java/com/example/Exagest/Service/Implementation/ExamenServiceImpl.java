package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.ExamenService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.CycleTypeExamen;
import com.example.Exagest.entities.Ecole;
import com.example.Exagest.entities.Examen;
import com.example.Exagest.repository.AnneeRepository;
import com.example.Exagest.repository.CycleTypeExamenRepository;
import com.example.Exagest.repository.EcoleRepository;
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

    private final EcoleRepository ecoleRepository;

    private final CycleTypeExamenRepository cycleTypeExamenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository, AnneeRepository anneeRepository, EcoleRepository ecoleRepository, CycleTypeExamenRepository cycleTypeExamenRepository) {
        this.examenRepository = examenRepository;
        this.anneeRepository = anneeRepository;
        this.ecoleRepository = ecoleRepository;
        this.cycleTypeExamenRepository = cycleTypeExamenRepository;
    }

    @Override
    public Examen addexamen(Examen examen) {
        System.out.println("ppppppppppppppppppppp DEBUT");
        System.out.println(examen);
        Annee a = anneeRepository.getCurrentYear();
        examen.setAnnee(a);
        examen.setAddDate(LocalDate.now());
        Optional<Ecole> el = ecoleRepository.findById(examen.getEcole().getId());
        Optional<Annee> an = anneeRepository.findById(examen.getAnnee().getId());
        Optional<CycleTypeExamen> ex = cycleTypeExamenRepository.findById(examen.getCycleTypeExamen().getId());
        System.out.println(el.isPresent());
        System.out.println(an.isPresent());
        System.out.println(ex.isPresent());
        if (el.isPresent() && an.isPresent() && ex.isPresent()){
            examen.setAnnee(an.get());
            examen.setEcole(el.get());
            examen.setCycleTypeExamen(ex.get());
//            System.out.println("ppppppppppppppppppppp FIN");
//            System.out.println(examen);
            return examenRepository.save(examen);
        }
        return examen;
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
