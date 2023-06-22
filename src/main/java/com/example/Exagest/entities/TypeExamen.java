package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "typeExamen")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TypeExamen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_TypeExamen")
    private Long id;
    @Column(nullable = false,length = 50)
    private String libelle_TypeExam;
    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;
    @ManyToOne
    @JoinColumn(name = "idCycleTypeExam")
    private CycleTypeExamen cycleTypeExamen;
}
