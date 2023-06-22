package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.AnneeService;
import com.example.Exagest.entities.Annee;
import com.example.Exagest.repository.AnneeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class AnneeServiceImpl implements AnneeService {
private final AnneeRepository anneeRepository;

    public AnneeServiceImpl(AnneeRepository anneeRepository) {
        this.anneeRepository = anneeRepository;
    }

    @Override
    public Annee addAnnee(Annee annee) {
        return null;
    }

    @Override
    public Annee editAnnee(Long id) {
        return null;
    }

    @Override
    public String deleteAnnee(Long id) {
        return null;
    }

    @Override
    public List<Annee> listAnnee() {
        return null;
    }
}
