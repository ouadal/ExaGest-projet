package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.EnrolementService;
import com.example.Exagest.entities.Enrolement;
import com.example.Exagest.repository.EnrolementRepository;

import java.util.List;

public class EnrolementServiceImpl implements EnrolementService {
    private final EnrolementRepository enrolementRepository;

    public EnrolementServiceImpl(EnrolementRepository enrolementRepository) {
        this.enrolementRepository = enrolementRepository;
    }

    @Override
    public Enrolement addenrolement(Enrolement enrolement) {
        return null;
    }

    @Override
    public Enrolement editenrolement(Long id) {
        return null;
    }

    @Override
    public String deleteenrolement(Long id) {
        return null;
    }

    @Override
    public List<Enrolement> listenrolement() {
        return null;
    }
}
