package com.example.Exagest.requests;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.Ecole;
import com.example.Exagest.entities.Eleve;
import com.example.Exagest.entities.Enrolement;
import jakarta.persistence.Column;
import lombok.*;
import java.time.LocalDate;
import java.util.Date;
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Data
public class InscriptionRequestModel {


    private String nom;


    private String prenom;


    private Date date_naissance;

    private String sexe;


    private int contactParent;


    private Long idEnrolement;

}
