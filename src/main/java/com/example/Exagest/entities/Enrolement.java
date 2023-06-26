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
@Table(name = "Enrolement")
@NoArgsConstructor
@AllArgsConstructor

public class Enrolement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enrolement")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idexamen")
    private Examen examen;

    @ManyToOne
    @JoinColumn(name = "idecole")
    private Ecole ecole;

    @Column(nullable = false)
    private LocalDate addDate;

    @Column(nullable = false)
    private LocalDate updateDate;


}
