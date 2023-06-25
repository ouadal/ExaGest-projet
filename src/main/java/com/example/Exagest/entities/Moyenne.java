package com.example.Exagest.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@Table(name = "moyenne")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Moyenne implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_Moyenne")
    private Long id;
    @Column(nullable = false,length = 50)
    private String libelleMoy;

    @Column(nullable = false,length = 50)
    private LocalDate dateAjout;
    @Column(nullable = false,length = 50)
    private LocalDate dateModife;
    @ManyToOne
    @JoinColumn(name = "idnote")
    private Note note;
}
