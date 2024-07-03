package pe.edu.cibertec.dsw.DSWII_T3_Landa.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PublicacionDto {
    private String titulo;
    private String resumen;
    private Date fechaPublicacion;
    private String nombreAutor;
    private String apellidoAutor;
}
