package com.example.Exagest.security.services.implementations;

import com.example.Exagest.Service.EcoleService;
import com.example.Exagest.entities.Ecole;
import com.example.Exagest.repository.EcoleRepository;
import com.example.Exagest.security.entities.Role;
import com.example.Exagest.security.entities.User;
import com.example.Exagest.security.exceptions.*;
import com.example.Exagest.security.repositories.RoleRepository;
import com.example.Exagest.security.repositories.UserRepository;
import com.example.Exagest.security.requests.*;
import com.example.Exagest.security.responses.HttpSuccessResponse;
import com.example.Exagest.security.services.UserService;
import com.example.Exagest.security.utils.JavaUtils;
import com.example.Exagest.security.utils.JwtUtils;
import com.example.Exagest.security.utils.SecurityJavaConverter;
import com.example.Exagest.security.utils.UserPrincipal;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.example.Exagest.security.utils.JavaUtils.successResponse;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

    @Value("${client.address}")
    private String frontendServerURL;
    private final EcoleService ecoleService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtUtils jwtUtils;
    private final JavaUtils javaUtils;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final SecurityJavaConverter javaConverter;


    public UserServiceImplementation(EcoleService ecoleService, UserRepository userRepository, RoleRepository roleRepository, JwtUtils jwtUtils, JavaUtils javaUtils, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager, SecurityJavaConverter javaConverter) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.jwtUtils = jwtUtils;
        this.javaUtils = javaUtils;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
        this.javaConverter = javaConverter;
        this.ecoleService = ecoleService;
    }

    @Override
    public HttpSuccessResponse storeUser(RegisterRequest request) throws RoleNotFoundException, UserAlreadyExistException, RoleAlreadyExistException, UnsupportedEncodingException {

        request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));


        Optional<User> userAvecMail = userRepository.findByEmail(request.getEmail());
        Optional<User> userAvecUsername = userRepository.findByUsername(request.getUsername());

        if (userAvecMail.isPresent()) {
            throw new UserAlreadyExistException("Un utilisateur avec cette adresse email est deja enregistré");
        }
        if (userAvecUsername.isPresent()) {
            throw new UserAlreadyExistException("Un utilisateur avec ce nom d'utilisateur est deja enregistré");
        }


        User user = userRepository.save(javaConverter.registerToUser(request));
        System.out.println("**********************************************");
        System.out.println(request.toString());
        System.out.println("**********************************************");
        ecoleService.addecole(new Ecole(null,request.getNom(),request.getAdresse(),request.getTelephone(),request.getEmail(),"No",false,"",request.getCycle(),null,null,user));

        if (request.getInitRoles() == null) {
            addRoleToUser("ROLE_USER", request.getUsername());
        } else {
            for (Role role : request.getInitRoles()) {
                addRoleToUser(role.getName(), request.getUsername());
            }
        }


        return successResponse(CREATED, "Votre compte a bien été créer.", javaConverter.userToUserResponse(user));
    }

    @Override
    public HttpSuccessResponse storeAdmin(AdminRegisterRequest request) throws UserAlreadyExistException, RoleNotFoundException, RoleAlreadyExistException {
        request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));


        Optional<User> userAvecMail = userRepository.findByEmail(request.getEmail());
        Optional<User> userAvecUsername = userRepository.findByUsername(request.getUsername());

        if (userAvecMail.isPresent()) {
            throw new UserAlreadyExistException("Un utilisateur avec cette adresse email est deja enregistré");


        }
        if (userAvecUsername.isPresent()) {
            throw new UserAlreadyExistException("Un utilisateur avec ce nom d'utilisateur est deja enregistré");
        }


        User user = userRepository.save(javaConverter.AdminRegisterToUser(request));

        addRoleToUser("ROLE_ADMIN", user.getUsername());
//        addRoleToUser("ROLE_VALIDATEUR_COMPTE", user.getUsername());
//        addRoleToUser("ROLE_VALIDATEUR_PUBLICATION", user.getUsername());
        return successResponse(CREATED, "Votre compte a bien été créer.", javaConverter.userToUserResponse(user));

    }

    @Override
    public HttpSuccessResponse storeValidateur(ValidateurRegisterRequest request) throws RoleNotFoundException, RoleAlreadyExistException {
        request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        User user = userRepository.save(javaConverter.ValidateurRegisterToUser(request));
        for (String role : request.getRoles()) {
            addRoleToUser(role, request.getUsername());
        }
        return successResponse(CREATED, "Compte créé avec succès.", user);
    }

    @Override
    public HttpSuccessResponse authUser(Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Utilisateur Non trouvée!"));
        return successResponse(OK, "Détails du compte de l'utilisateur", user.map(javaConverter::userToUserResponse));
    }

    @Override
    public void addRoleToUser(String roleName, String username) throws RoleNotFoundException, RoleAlreadyExistException {
        Optional<Role> role = roleRepository.findByName(roleName);
        role.orElseThrow(() -> new RoleNotFoundException("Role n'existe pas"));
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            for (Role r : user.get().getRoles()) {
                if (r.getId().equals(role.get().getId())) {
                    throw new RoleAlreadyExistException("Ce role existe déjà pour cet utilisateur");
                }
            }
        }
        user
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur n'existe pas"))
                .getRoles()
                .add(role.get());
        userRepository.save(user.get());
    }

//    @Override
//    public HttpSuccessResponse changePasswordRequest(ChangePasswordRequest request) throws UserNotFoundException {
//
//        Optional<User> optionalUser = userRepository.findBytoken(request.getToken());
//
//        if (optionalUser.isEmpty()) {
//            throw new UserNotFoundException("Token invalid. Veuillez cliquez sur le lien envoyé par email " +
//                    "pour envoyer votre requête");
//        }
//        optionalUser.get().setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
//        userRepository.save(optionalUser.get());
//
//        return successResponse(CREATED, "Votre mot de passe a bien été mis à jour.", javaConverter.userToUserResponse(optionalUser.get()));
//    }

    @Override
    public HttpSuccessResponse allUser() {

        List<User> all = userRepository.findAll();

        return new HttpSuccessResponse(OK, 200, "Récupération des utilisateurs réussi", all);
    }

    @Override
    public String authenticate(LoginRequest request) throws UserNotFoundException {

        Optional<User> user = userRepository.findByUsername(request.getUsername());
        user.orElseThrow(() -> new UserNotFoundException("Aucun utilisateur n'existe avec cet nom d'utilisateur!"));
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getCredentials());
        System.out.println(authentication.getPrincipal());
        System.out.println(authentication.getAuthorities());
        System.out.println("---------------------after authenticate");
        System.out.println("---------------------here");
        return jwtUtils.generateToken(user.map(UserPrincipal::new).get());

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Utilisateur n'existe pas dans la base."));
        return user.map(UserPrincipal::new).get();
    }

    @Override
    public UserDetails loadByEmail(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("Utilisateur n'existe pas dans la base."));
        return user.map(UserPrincipal::new).get();
    }
}
