package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.EcoleService;
import com.example.Exagest.entities.Ecole;
import com.example.Exagest.repository.EcoleRepository;

import java.util.List;
import java.util.Optional;

public class EcoleServiceImpl implements EcoleService {
    private final EcoleRepository ecoleRepository;

    public EcoleServiceImpl(EcoleRepository ecoleRepository) {
        this.ecoleRepository = ecoleRepository;
    }

    @Override
    public Ecole addecole(Ecole ecole) {
        return ecoleRepository.save(ecole);
    }

    @Override
    public Ecole editecole(Long id,Ecole ecole) {
        Optional<Ecole> optionalEcole =ecoleRepository.findById(id);
        if(optionalEcole.isEmpty()){
            System.out.println("Ecole modifié avec succès");
        }
        Ecole dbEcole = optionalEcole.get();
        dbEcole.setDateAjout(ecole.getDateAjout());
        dbEcole.setEmail(ecole.getEmail());
        dbEcole.setNomEcole(ecole.getNomEcole());
        dbEcole.setAdresse(ecole.getAdresse());
        dbEcole.setExamen(ecole.getExamen());
        dbEcole.setFicheStatut(ecole.getFicheStatut());
        dbEcole.setMatricule(String.format("%08d", dbEcole.getId()));
        dbEcole.setStatut(ecole.isStatut());
        dbEcole.setTelephone(ecole.getTelephone());
        dbEcole.setDateModife(ecole.getDateModife());
        return ecoleRepository.save(dbEcole);    }

    @Override
    public String deleteecole(Long id) {
        ecoleRepository.deleteById(id);
        return "Ecole est supprimé avec succès";
    }

    @Override
    public List<Ecole> listecole() {
        return ecoleRepository.findAll();
    }
}