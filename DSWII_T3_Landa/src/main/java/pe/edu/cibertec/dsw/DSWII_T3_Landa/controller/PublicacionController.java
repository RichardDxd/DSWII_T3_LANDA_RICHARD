package pe.edu.cibertec.dsw.DSWII_T3_Landa.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.dsw.DSWII_T3_Landa.model.Publicacion;
import pe.edu.cibertec.dsw.DSWII_T3_Landa.repository.PublicacionRepository;
import pe.edu.cibertec.dsw.DSWII_T3_Landa.model.bd.PublicacionDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pubs-dto")
public class PublicacionController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PublicacionRepository publicacionRepository;

    @GetMapping
    public List<PublicacionDto> getAllPublicaciones() {
        List<Publicacion> publicaciones = publicacionRepository.findAll();
        return publicaciones.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private PublicacionDto convertToDto(Publicacion publicacion) {
        PublicacionDto publicacionDto = modelMapper.map(publicacion, PublicacionDto.class);
        publicacionDto.setNombre(publicacion.getAutor().getNomAutor());
        publicacionDto.setApellido(publicacion.getAutor().getApeAutor());
        return publicacionDto;
    }
}
