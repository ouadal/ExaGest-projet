package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "periode")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Periode implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_periode")
    private Long id;
    @Column(nullable = false,length = 50)
    private String libellePeriode;
    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;
}
