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
@Table(name = "enrolement")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Enrolement implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_enrolement")
    private Long id;
    @Column(nullable = false,length = 50)
    private Date dateEnrolement;
    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;
    @ManyToOne
    @JoinColumn(name = "idinscription")
    private Inscription inscription;

}
