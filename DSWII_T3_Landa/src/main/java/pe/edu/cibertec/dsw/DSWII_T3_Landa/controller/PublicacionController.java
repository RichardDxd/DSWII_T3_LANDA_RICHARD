package pe.edu.cibertec.dsw.DSWII_T3_Landa.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.dsw.DSWII_T3_Landa.model.Publicacion;
import pe.edu.cibertec.dsw.DSWII_T3_Landa.model.dto.PublicacionDto;
import pe.edu.cibertec.dsw.DSWII_T3_Landa.service.PublicacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pubs-dto")
public class PublicacionController {

    private final PublicacionService publicacionService;
    private final ModelMapper modelMapper;

    @Autowired
    public PublicacionController(PublicacionService publicacionService, ModelMapper modelMapper) {
        this.publicacionService = publicacionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    @PreAuthorize("hasRole('COORDINADOR')")
    public ResponseEntity<List<PublicacionDto>> obtenerPublicaciones() {
        List<Publicacion> publicaciones = publicacionService.obtenerPublicaciones();
        List<PublicacionDto> publicacionesDto = publicaciones.stream()
                .map(publicacion -> modelMapper.map(publicacion, PublicacionDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(publicacionesDto, HttpStatus.OK);
    }
}
