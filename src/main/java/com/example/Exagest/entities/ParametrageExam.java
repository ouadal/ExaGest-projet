package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "ParamExamen")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParametrageExam implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ParamExam")
    private Long id;
    @Column(nullable = false,length = 50)
    private int nombreCredit;
    @Column(nullable = false,length = 50)
    private boolean etat;
    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;

}
