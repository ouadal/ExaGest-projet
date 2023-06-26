package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
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

    @Column(length = 100,nullable = false)
    private float noteExam;

    @Column(nullable = false)
    private boolean statut;

    @Column(nullable = false)
    private LocalDate addDate;


    @Column(nullable = false)
    private LocalDate updateDate;

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

}
