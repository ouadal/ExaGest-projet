package com.example.Exagest.security.services;

import com.example.Exagest.security.exceptions.*;
import com.example.Exagest.security.requests.*;
import com.example.Exagest.security.responses.HttpSuccessResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.UnsupportedEncodingException;

public interface UserService extends UserDetailsService {

    void addRoleToUser(String roleName, String username) throws RoleNotFoundException, RoleAlreadyExistException;
    //void ROLE_ADMINISTRATEUR(String roleName, String username) throws RoleNotFoundException, RoleAlreadyExistException;



    String authenticate(LoginRequest request) throws UserNotFoundException;

    HttpSuccessResponse storeUser(RegisterRequest request) throws RoleNotFoundException, UserAlreadyExistException, RoleAlreadyExistException, UnsupportedEncodingException;

    HttpSuccessResponse storeAdmin(AdminRegisterRequest request) throws UserAlreadyExistException, RoleNotFoundException, RoleAlreadyExistException;

    HttpSuccessResponse storeValidateur(ValidateurRegisterRequest validateurRegisterRequest) throws RoleNotFoundException, RoleAlreadyExistException;

    HttpSuccessResponse authUser(Authentication authentication);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    UserDetails loadByEmail(String email);

    HttpSuccessResponse allUser();


}
