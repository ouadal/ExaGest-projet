package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.MoyenneService;
import com.example.Exagest.entities.Moyenne;
import com.example.Exagest.repository.MoyenneRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class MoyenneServiceImpl implements MoyenneService {
    private final MoyenneRepository moyenneRepository;

    public MoyenneServiceImpl(MoyenneRepository moyenneRepository) {
        this.moyenneRepository = moyenneRepository;
    }

    @Override
    public Moyenne addmoyenne(Moyenne moyenne) {
        return null;
    }

    @Override
    public Moyenne editmoyenne(Long id) {
        return null;
    }

    @Override
    public String deletemoyenne(Long id) {
        return null;
    }

    @Override
    public List<Moyenne> listmoyenne() {
        return null;
    }
}
