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
@Table(name = "enrolement")
@NoArgsConstructor
@AllArgsConstructor

public class Enrolement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_enrolement")
    private Long id;

    @Column(nullable = false)
    private LocalDate addDate;

    @Column(nullable = false)
    private LocalDate updateDate;

    @ManyToOne
    @JoinColumn(name = "idexamen")
    private Examen examen;

    @ManyToOne
    @JoinColumn(name = "idecole")
    private Ecole ecole;






}
