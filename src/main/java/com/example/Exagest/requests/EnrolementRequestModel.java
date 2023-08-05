package com.example.Exagest.requests;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EnrolementRequestModel {

    private String libele;

    private boolean statut = false;

    private Long  idEcole;

    private Long  idCycleTypeExamen;


}
