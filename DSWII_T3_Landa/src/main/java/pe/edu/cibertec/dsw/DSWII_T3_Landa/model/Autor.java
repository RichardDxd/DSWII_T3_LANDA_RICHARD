package pe.edu.cibertec.dsw.DSWII_T3_Landa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdAutor;

    private String NomAutor;
    private String ApeAutor;
    private Date FechNacAutor;
}
