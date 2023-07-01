package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "Session")
@NoArgsConstructor
@AllArgsConstructor

public class Session implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_session")
    private Long id;

    @Column(nullable = false,length = 100)
    private String libele;

    @Column(nullable = false)
    private LocalDate addDate;

    @Column(nullable = true)
    private LocalDate updateDdate;
}
