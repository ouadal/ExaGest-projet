package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "CycleTypeExamen")
@NoArgsConstructor
@AllArgsConstructor

public class CycleTypeExamen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_CycleTypeExamen")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idcycle")
    private Cycle cycle;

    @ManyToOne
    @JoinColumn(name = "idtypeExamen")
    private TypeExamen typeExamen;

    @Column(nullable = false)
    private LocalDate addDate;

    @Column(nullable = false)
    private LocalDate updateDate;




}
