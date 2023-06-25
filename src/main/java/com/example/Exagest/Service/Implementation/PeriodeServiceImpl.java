package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.SectionService;
import com.example.Exagest.entities.Section;
import com.example.Exagest.repository.SectionRepository;

import java.util.List;
import java.util.Optional;

public class PeriodeServiceImpl implements SectionService {
    private final SectionRepository periodeRepository;

    public PeriodeServiceImpl(SectionRepository periodeRepository) {
        this.periodeRepository = periodeRepository;
    }

    @Override
    public Section addperiode(Section periode) {
        return periodeRepository.save(periode);
    }

    @Override
    public Section editperiode(Long id, Section periode) {
        Optional<Section> optionalPeriode =periodeRepository.findById(id);
        if(optionalPeriode.isEmpty()){
            System.out.println("Periode modifié avec succès");
        }
        Section dbPeriode = optionalPeriode.get();
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
    public List<Section> listperiode() {
        return periodeRepository.findAll();
    }
}
