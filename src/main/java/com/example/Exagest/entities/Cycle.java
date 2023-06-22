package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "cycle")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cycle implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cycle")
    private Long id;
    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;
    @Column(nullable = false,length = 50)
    private String libelleCycle;
    @ManyToOne
    @JoinColumn(name = "idCycleTypeExam")
    private CycleTypeExamen cycleTypeExamen;
    @ManyToOne
    @JoinColumn(name = "idTypeExam")
    private TypeExamen typeExamen;
}
