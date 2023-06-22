package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "typeMat")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TypeMat implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_TypeMat")
    private Long id;
    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;
    @ManyToOne
    @JoinColumn(name = "idmatiere")
    private Matiere matiere;
}
