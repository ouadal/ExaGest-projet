package com.example.Exagest.Service;

import com.example.Exagest.entities.Periode;

import java.util.List;

public interface PeriodeService {
   Periode addperiode(Periode periode);
   Periode editperiode( Long id);
    String deleteperiode(Long id);
    List<Periode> listperiode();
}
