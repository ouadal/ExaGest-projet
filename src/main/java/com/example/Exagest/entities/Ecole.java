package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "ecole")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ecole implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ecole")
    private Long id;
    @Column(nullable = false)
    private String NomEcole;
    @Column(nullable = false)
    private String Adresse;
    @Column(nullable = false,length = 50)
    private int Telephone;
    @Column(nullable = false)
    private String Email;
    @Column(nullable = false)
    private String ficheStatut;
    @Column(nullable = false,length = 50)
    private boolean Statut;
    @Column(nullable = false,length = 50)
    private String Matricule;
    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;

}
