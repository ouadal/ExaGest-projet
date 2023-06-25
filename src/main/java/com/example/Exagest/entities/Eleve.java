package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter @Getter @ToString @Table(name = "eleve")
@NoArgsConstructor @AllArgsConstructor @Data
public class Eleve implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Eleve")
    private Long id;
    @Column(nullable = false)
    private String Nom;
    @Column(nullable = false)
    private String Prenom;
    @Column(nullable = false)
    private Date date_naissance;
    @Column(nullable = false,length = 50,unique = true)
    private int contactParent;
    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;
    @ManyToOne
    @JoinColumn(name = "idannee")
    private Annee annee;
}
