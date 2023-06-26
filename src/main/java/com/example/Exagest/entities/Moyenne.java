package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "moyenne")
@NoArgsConstructor
@AllArgsConstructor

public class Moyenne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_Moyenne")
    private Long id;

    @Column(nullable = false)
    private LocalDate updateDate;

    @Column(nullable = false)
    private LocalDate addDate;

    @ManyToOne
    @JoinColumn(name = "idinscription")
    private Inscription inscription;

    @ManyToOne
    @JoinColumn(name = "idexamen")
    private Examen examen;

    @ManyToOne
    @JoinColumn(name = "idsession")
    private Session session;

}
