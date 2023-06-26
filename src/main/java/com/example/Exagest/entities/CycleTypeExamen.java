package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "cycleTypeExamen")
@NoArgsConstructor
@AllArgsConstructor

public class CycleTypeExamen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_CycleTypeExamen")
    private Long id;

    @Column(nullable = false)
    private LocalDate addDate;

    @Column(nullable = false)
    private LocalDate updateDate;

    @ManyToOne
    @JoinColumn(name = "idcycle")
    private Cycle cycle;

    @ManyToOne
    @JoinColumn(name = "idtypeExamen")
    private TypeExamen typeExamen;




}
