package com.example.Exagest.Service.Implementation;

import com.example.Exagest.Service.OperateurService;
import com.example.Exagest.entities.Operateur;
import com.example.Exagest.repository.OperateurRepository;

import java.time.LocalDate;
import java.util.Optional;

public class OperateurServiceImpl implements OperateurService {

    private final OperateurRepository operateurRepository;

    public OperateurServiceImpl(OperateurRepository operateurRepository) {
        this.operateurRepository = operateurRepository;
    }

    @Override
    public Operateur findByIdOfOp(Long id) {
        return operateurRepository.findById(id).orElseThrow();
    }

    @Override
    public Operateur addop(Operateur operateur) {
        operateur.setAddDate(LocalDate.now());
        return operateurRepository.save(operateur);
    }

    @Override
    public Operateur editop(Operateur operateur, Long id) {
        Optional<Operateur> optionalOperateur =operateurRepository.findById(id);
        if(optionalOperateur.isEmpty()){
            System.out.println("operateur modifié avec succès");
        }
       Operateur dbOperateur =optionalOperateur.get();
        dbOperateur.setUpdateDate(LocalDate.now());
        return operateurRepository.save(dbOperateur);

    }

    @Override
    public String deleteop(Long id) {
      operateurRepository.deleteById(id);
        return "op supprimer avec succès ";
    }
}
