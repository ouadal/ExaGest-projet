package com.example.Exagest.security.requests;


import com.example.Exagest.entities.Cycle;
import com.example.Exagest.security.entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@Data
public class RegisterRequest {

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;

    @Email
    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String nom;

//    @NotNull
//    @NotBlank
//    private String prenom;

    @NotNull
    @NotBlank
    private String telephone;

    @NotNull
    @NotBlank
    private String adresse;

    @NotNull
    @NotBlank
    private Cycle cycle;

    private List<Role> initRoles;
}
