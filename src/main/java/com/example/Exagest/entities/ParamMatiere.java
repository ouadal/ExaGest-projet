package com.example.Exagest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "paramMatiere")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParamMatiere implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_paramMatiere")
    private Long id;
    @Column(nullable = false,length = 50)
    private int nombreCredit;
    @Column(nullable = false,length = 50)
    private boolean etat;
    @Column(nullable = false,length = 50)
    private int coefficient;
    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;
    @ManyToOne
    @JoinColumn(name = "idexamen")
    private Examen examen;
    @ManyToOne
    @JoinColumn(name = "idmatiere")
    private Matiere matiere;

}
