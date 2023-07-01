package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "Moyenne")
@NoArgsConstructor
@AllArgsConstructor

public class Moyenne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Moyenne")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idinscription")
    private Inscription inscription;

    @ManyToOne
    @JoinColumn(name = "idexamen")
    private Examen examen;

    @ManyToOne
    @JoinColumn(name = "idsession")
    private Session session;

    @Column(nullable = true)
    private LocalDate updateDate;

    @Column(nullable = false)
    private LocalDate addDate;

}
