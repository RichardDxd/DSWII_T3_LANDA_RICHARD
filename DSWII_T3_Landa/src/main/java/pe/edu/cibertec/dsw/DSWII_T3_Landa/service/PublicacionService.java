package pe.edu.cibertec.dsw.DSWII_T3_Landa.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dsw.DSWII_T3_Landa.model.Publicacion;
import pe.edu.cibertec.dsw.DSWII_T3_Landa.repository.PublicacionRepository;

import java.util.List;

@Service
public class PublicacionService {
    @Autowired
    private PublicacionRepository publicacionRepository;

    public List<Publicacion> obtenerPublicaciones() {
        return publicacionRepository.findAll();
    }
}
