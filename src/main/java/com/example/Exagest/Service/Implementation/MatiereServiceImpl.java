package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.MatiereService;
import com.example.Exagest.entities.Matiere;
import com.example.Exagest.repository.MatiereRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MatiereServiceImpl implements MatiereService {
    private final MatiereRepository matiereRepository;

    public MatiereServiceImpl(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }

    @Override
    public Matiere addmatiere(Matiere matiere) {
        return null;
    }

    @Override
    public Matiere editmatiere(Long id) {
        return null;
    }

    @Override
    public String deletematiere(Long id) {
        return null;
    }

    @Override
    public List<Matiere> listmatiere() {
        return null;
    }
}
