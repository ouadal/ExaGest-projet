package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "Matiere")
@NoArgsConstructor
@AllArgsConstructor
public class Matiere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matiere")
    private Long id;

    @Column(nullable = false,length = 100)
    private String libele;

    @Column(nullable = false,length = 100)
    private String codeMat;

    @ManyToOne
    @JoinColumn(name = "idtypeMatiere")
    private TypeMat typeMat;

    @Column(nullable = false)
    private LocalDate addDate;

    @Column(nullable = false)
    private LocalDate updateDate;
}
