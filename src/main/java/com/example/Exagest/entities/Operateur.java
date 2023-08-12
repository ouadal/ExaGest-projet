package com.example.Exagest.entities;

import com.example.Exagest.security.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "operateurs")
@NoArgsConstructor
@AllArgsConstructor

public class Operateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operateur")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idexamen")
    private Examen examen;

    @Column(nullable = false)
    private LocalDate addDate;


    @Column(nullable = true)
    private LocalDate updateDate;

}
