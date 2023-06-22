package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "Note")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Note implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_note")
    private Long id;
    @Column(length = 50,nullable = false)
    private float noteExam;
    @Column(nullable = false,length = 50)
    private boolean Statut;
    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private int coefficient;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;
    @ManyToOne
    @JoinColumn(name = "idparamMat")
    private ParametrageExam parametrageExam;
    @ManyToOne
    @JoinColumn(name = "idmoyenne")
    private Moyenne moyenne;
}
