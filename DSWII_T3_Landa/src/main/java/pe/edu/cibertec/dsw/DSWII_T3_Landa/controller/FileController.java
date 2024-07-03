package pe.edu.cibertec.dsw.DSWII_T3_Landa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.dsw.DSWII_T3_Landa.service.FileService;

import java.util.List;

@RestController
@RequestMapping("/filesimages")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<String> subirArchivos(@RequestParam("files") List<MultipartFile> multipartFiles) {
        try {
            for (MultipartFile file : multipartFiles) {
                if (!file.getOriginalFilename().endsWith(".png")) {
                    return new ResponseEntity<>("Solo se permiten archivos PNG", HttpStatus.BAD_REQUEST);
                }
            }
            fileService.guardarArchivos(multipartFiles);
            return new ResponseEntity<>("Archivos subidos correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al subir archivos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
