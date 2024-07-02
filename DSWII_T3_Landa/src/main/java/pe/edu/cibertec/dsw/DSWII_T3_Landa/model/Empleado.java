package pe.edu.cibertec.dsw.DSWII_T3_Landa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado")

public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEmpleado;

    private String Nombre;
    private String Apellido;
    private Date FechaContrat;

    @ManyToOne
    @JoinColumn(name = "IdDomicilio")
    private Domicilio domicilio;
}
