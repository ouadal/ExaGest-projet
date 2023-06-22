package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.InscriptionService;
import com.example.Exagest.entities.Inscription;
import com.example.Exagest.repository.InscriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class InscriptionServiceImpl implements InscriptionService {
    private final InscriptionRepository inscriptionRepository;

    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public Inscription addinscription(Inscription inscription) {
        return null;
    }

    @Override
    public Inscription editinscriptionn(Long id) {
        return null;
    }

    @Override
    public String deleteinscription(Long id) {
        return null;
    }

    @Override
    public List<Inscription> listinscription() {
        return null;
    }
}
