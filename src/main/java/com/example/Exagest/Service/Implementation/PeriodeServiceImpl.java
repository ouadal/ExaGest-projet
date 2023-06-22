package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.PeriodeService;
import com.example.Exagest.entities.Periode;
import com.example.Exagest.entities.TypeMat;
import com.example.Exagest.repository.PeriodeRepository;

import java.util.List;
import java.util.Optional;

public class PeriodeServiceImpl implements PeriodeService {
    private final PeriodeRepository periodeRepository;

    public PeriodeServiceImpl(PeriodeRepository periodeRepository) {
        this.periodeRepository = periodeRepository;
    }

    @Override
    public Periode addperiode(Periode periode) {
        return periodeRepository.save(periode);
    }

    @Override
    public Periode editperiode(Long id,Periode periode) {
        Optional<Periode> optionalPeriode =periodeRepository.findById(id);
        if(optionalPeriode.isEmpty()){
            System.out.println("Periode modifié avec succès");
        }
        Periode dbPeriode = optionalPeriode.get();
        dbPeriode.setDateAjout(periode.getDateAjout());
        dbPeriode.setLibellePeriode(periode.getLibellePeriode());
        dbPeriode.setDateModife(periode.getDateModife());
        return periodeRepository.save(dbPeriode);

    }

    @Override
    public String deleteperiode(Long id) {
        periodeRepository.deleteById(id);
        return "période supprimer avec succès ";
    }

    @Override
    public List<Periode> listperiode() {
        return periodeRepository.findAll();
    }
}
