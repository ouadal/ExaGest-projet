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
@Table(name = "Inscription")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Inscription implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_inscription")
    private Long id;
    @Column(nullable = false,length = 50)
    private boolean Statut;
    @Column(nullable = false,length = 50)
    private Date dateEnrole;
    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;
    @ManyToOne
    @JoinColumn(name = "idnote")
    private Note note;
}
