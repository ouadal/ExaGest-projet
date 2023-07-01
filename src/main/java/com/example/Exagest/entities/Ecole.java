package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "Ecole")
@NoArgsConstructor
@AllArgsConstructor
public class Ecole implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ecole")
    private Long id;

    @Column(nullable = false)
    private String nomEcole;

    @Column(nullable = false ,length = 100)
    private String adresse;

    @Column(nullable = false,length = 100)
    private int telephone;

    @Column(nullable = false,length = 100,unique = true)
    private String email;

    @Column(nullable = false)
    private String ficheStatut;

    @Column(nullable = false)
    private boolean Statut;

    @Column(nullable = false,length = 100)
    private String Matricule;

    @ManyToOne
    @JoinColumn(name = "idcycle")
    private Cycle cycle;

    @Column(nullable = false)
    private LocalDate addDate;

    @Column(nullable = true)
    private LocalDate updateDate;


}
