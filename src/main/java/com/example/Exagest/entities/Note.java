package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "Note")
@NoArgsConstructor
@AllArgsConstructor


public class Note implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_note")
    private Long id;

    @Column(nullable = false)
    private boolean statut;

    @Min(value = 0,message = "Note ne dois pas etre inferieur a 0")
   @Max(value = 20,message = "Note ne dois pas dépasser 20")
    @Column(length = 100,nullable = false)
    private float noteExam;

    @ManyToOne
    @JoinColumn(name = "idinscription")
    private Inscription inscription;

    @ManyToOne
    @JoinColumn(name = "idattribution")
    private AttributionMatiere attributionMatiere;

    @ManyToOne
    @JoinColumn(name = "idsession")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "idexamen")
    private Examen examen;

    @Column(nullable = false)
    private LocalDate addDate;


    @Column(nullable = true)
    private LocalDate updateDate;

}
