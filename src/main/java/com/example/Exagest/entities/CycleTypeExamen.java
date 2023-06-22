package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "cycleTypeExamen")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CycleTypeExamen implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_CycleTypeExamen")
    private Long id;
    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;
    @Column(nullable = false,length = 50)
    private String libelleCycleTypeExam;

}
