package pe.edu.cibertec.dsw.DSWII_T3_Landa.model.bd;

import lombok.Data;

import java.util.Date;

@Data
public class PublicacionDto {
    private String titulo;
    private String resumen;
    private Date fechaPublicacion;
    private String nombre;
    private String apellido;
}
