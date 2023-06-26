package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "Examen")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Examen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Examen")
    private Long id;

    @Column(nullable = false,length = 100)
    private String libele;

    @Column(nullable = false)
    private boolean statut;

    @ManyToOne
    @JoinColumn(name = "idCycleTypeExam")
    private CycleTypeExamen cycleTypeExamen;

    @ManyToOne
    @JoinColumn(name = "idannee")
    private Annee annee;

    @ManyToOne
    @JoinColumn(name = "idecole")
    private Ecole ecole;

    @Column(nullable = false)
    private LocalDate addDate;

    @Column(nullable = false)
    private LocalDate updateDate;

 
}
