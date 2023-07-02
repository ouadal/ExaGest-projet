package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.EcoleService;
import com.example.Exagest.entities.Cycle;
import com.example.Exagest.entities.Ecole;
import com.example.Exagest.repository.CycleRepository;
import com.example.Exagest.repository.EcoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional

public class EcoleServiceImpl implements EcoleService {
    private final EcoleRepository ecoleRepository;
    private final CycleRepository cycleRepository;

    public EcoleServiceImpl(EcoleRepository ecoleRepository, CycleRepository cycleRepository) {
        this.ecoleRepository = ecoleRepository;
        this.cycleRepository = cycleRepository;
    }

    @Override
    public Ecole addecole(Ecole ecole) {
        ecole.setAddDate(LocalDate.now());
        ecole.setMatricule(generateMatricule(8));
        Optional<Cycle> cycle = this.cycleRepository.findById(ecole.getCycle().getId());
        //Je vérifie si cycle ayant l'id saisi dans le postman existe si oui on fait un set de ce cycle et un return du save
        //Sinon on retourne un null
        // Mais le return null là tu peux le modifier
        if(cycle.isPresent()){
            ecole.setCycle(cycle.get());
            return ecoleRepository.save(ecole);
        }
        Ecole e = ecoleRepository.save(ecole);

        //e.setMatricule(String.format("%08d",e.getId()));//
        return ecoleRepository.save(e);
    }

    @Override
    public Ecole editecole(Long id,Ecole ecole) {
        Optional<Ecole> optionalEcole =ecoleRepository.findById(id);
        if(optionalEcole.isEmpty()){
            System.out.println("Ecole modifié avec succès");
        }
        Ecole dbEcole = optionalEcole.get();
        dbEcole.setUpdateDate(LocalDate.now());
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



    public String generateMatricule(int length) {
        String format = "%0" + length + "d";
        Random random = new Random();
        int randomNumber = random.nextInt((int) Math.pow(10, length));
        return String.format(format, randomNumber);
    }

}