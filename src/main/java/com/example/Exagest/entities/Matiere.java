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
@Data
public class Matiere implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_matiere")
    private Long id;
    @Column(nullable = false,length = 50)
    private String libelleMat;
    @Column(nullable = false,length = 50)
    private String codeMat;
    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;
    @ManyToOne
    @JoinColumn(name = "idparamMat")
    private ParametrageExam parametrageExam;
}
