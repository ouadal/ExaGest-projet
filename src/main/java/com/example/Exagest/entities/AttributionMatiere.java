package com.example.Exagest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "attributionMat")
@NoArgsConstructor
@AllArgsConstructor

public class AttributionMatiere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_attributionMat")
    private Long id;

    @Column(nullable = false)
    private LocalDate updateDate;

    @Column(nullable = false)
    private LocalDate addDate;

    @Column(nullable = false,length = 100)
    private int coefficient;

    @ManyToOne
    @JoinColumn(name = "idannee")
    private Annee annee;

    @ManyToOne
    @JoinColumn(name = "idmatiere")
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "idexamen")
    private Examen examen;




}
