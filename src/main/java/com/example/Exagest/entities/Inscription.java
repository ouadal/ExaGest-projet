package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter
@Getter
@ToString
@Table(name = "Inscription")
@NoArgsConstructor
@AllArgsConstructor
public class Inscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscription")
    private Long id;

    @Column(nullable = false)
    private boolean statut;

    @Column(nullable = false)
    private LocalDate addDate;

    @Column(nullable = false)
    private LocalDate updateDate;

    @ManyToOne
    @JoinColumn(name = "idenrolement")
    private Enrolement enrolement;

    @ManyToOne
    @JoinColumn(name = "idannee")
    private Annee annee;

    @ManyToOne
    @JoinColumn(name = "ideleve")
    private Eleve eleve;

    @ManyToOne
    @JoinColumn(name = "idecole")
    private Ecole ecole;
}
