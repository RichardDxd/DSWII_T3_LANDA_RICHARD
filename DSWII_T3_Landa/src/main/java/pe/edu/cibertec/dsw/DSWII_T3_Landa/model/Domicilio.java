package pe.edu.cibertec.dsw.DSWII_T3_Landa.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "domicilio")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdDomicilio;

    private String DescDomicilio;
    private Integer NroDomicilio;
    private String RefDomicilio;
}
