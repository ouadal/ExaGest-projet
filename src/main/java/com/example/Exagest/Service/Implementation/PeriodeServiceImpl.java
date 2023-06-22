package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.PeriodeService;
import com.example.Exagest.entities.Periode;
import com.example.Exagest.repository.PeriodeRepository;

import java.util.List;

public class PeriodeServiceImpl implements PeriodeService {
    private final PeriodeRepository periodeRepository;

    public PeriodeServiceImpl(PeriodeRepository periodeRepository) {
        this.periodeRepository = periodeRepository;
    }

    @Override
    public Periode addperiode(Periode periode) {
        return null;
    }

    @Override
    public Periode editperiode(Long id) {
        return null;
    }

    @Override
    public String deleteperiode(Long id) {
        return null;
    }

    @Override
    public List<Periode> listperiode() {
        return null;
    }
}
