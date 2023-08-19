package com.example.Exagest.models;

import com.example.Exagest.entities.Ecole;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TauxReussiteParEcole {
    private Ecole ecole;
    private Double taux;
}
