package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter
@Getter
@ToString
@Table(name = "annee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Annee implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_annee")
    private Long id;
    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;
    @Column(nullable = false,length = 50)
    private Date anneeScolaire;
    @Column(nullable = false,length = 50)
    private String libelleAnnee;

}
