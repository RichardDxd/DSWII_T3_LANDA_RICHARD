package pe.edu.cibertec.dsw.DSWII_T3_Landa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdPublicacion;

    private String Titulo;
    private String Resumen;
    private Date FechPublicacion;

    @ManyToOne
    @JoinColumn(name = "IdAutor")
    private Autor autor;
}
