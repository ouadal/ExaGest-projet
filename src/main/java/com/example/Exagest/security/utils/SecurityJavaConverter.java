package com.example.Exagest.security.utils;

import com.example.Exagest.entities.Ecole;
import com.example.Exagest.repository.EcoleRepository;
import com.example.Exagest.security.entities.User;
import com.example.Exagest.security.requests.AdminRegisterRequest;
import com.example.Exagest.security.requests.RegisterRequest;
import com.example.Exagest.security.requests.ValidateurRegisterRequest;
import com.example.Exagest.security.responses.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityJavaConverter {

    private final EcoleRepository ecoleRepository;
    @Autowired
    public SecurityJavaConverter(EcoleRepository ecoleRepository) {
        this.ecoleRepository = ecoleRepository;
    }

    public User registerToUser(RegisterRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request, user);
        return user;
    }

    public User AdminRegisterToUser(AdminRegisterRequest request){
        User user = new User();
        BeanUtils.copyProperties(request, user);
        return user;
    }

    public User ValidateurRegisterToUser(ValidateurRegisterRequest request){
        User user = new User();
        BeanUtils.copyProperties(request, user);
        return user;
    }

    public UserResponse userToUserResponse(User user) {
        UserResponse response = new UserResponse();
        Optional<Ecole> ecole = ecoleRepository.findByUserId(user.getId());
        //Optional<Demandeur> demandeur = demandeurRepository.findByUserId(user.getId());
        if(ecole.isPresent()){
           response.setInformations(ecole);
        }
//        else {
//            if(demandeur.isPresent()){
//                response.setInformations(demandeur);
//            }
//        }
        BeanUtils.copyProperties(user, response);
        return response;
    }

}
