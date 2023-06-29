package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.EcoleService;
import com.example.Exagest.entities.Ecole;
import com.example.Exagest.repository.EcoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class EcoleServiceImpl implements EcoleService {
    private final EcoleRepository ecoleRepository;

    public EcoleServiceImpl(EcoleRepository ecoleRepository) {
        this.ecoleRepository = ecoleRepository;
    }

    @Override
    public Ecole addecole(Ecole ecole) {
        Ecole e = ecoleRepository.save(ecole);
        e.setMatricule(String.format("%08d",e.getId()));
        return ecoleRepository.save(e);
    }

    @Override
    public Ecole editecole(Long id,Ecole ecole) {
        Optional<Ecole> optionalEcole =ecoleRepository.findById(id);
        if(optionalEcole.isEmpty()){
            System.out.println("Ecole modifié avec succès");
        }
        Ecole dbEcole = optionalEcole.get();
        dbEcole.setCycle(ecole.getCycle());
        dbEcole.setEmail(ecole.getEmail());
        dbEcole.setNomEcole(ecole.getNomEcole());
        dbEcole.setAdresse(ecole.getAdresse());
        dbEcole.setFicheStatut(ecole.getFicheStatut());
        dbEcole.setStatut(ecole.isStatut());
        dbEcole.setTelephone(ecole.getTelephone());

        return ecoleRepository.save(dbEcole);    }

    @Override
    public String deleteecole(Long id) {
        ecoleRepository.deleteById(id);
        return "Ecole est supprimé avec succès";
    }

    @Override
    public List<Ecole> listEcolCycle() {
        return ecoleRepository.listEcolCycle();
    }

    @Override
    public List<Ecole> listNomEcol() {
        return ecoleRepository.listNomEcol();
    }

}