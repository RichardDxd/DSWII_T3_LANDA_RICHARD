package pe.edu.cibertec.dsw.DSWII_T3_Landa.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService {

    private final String UPLOAD_DIR = "Images";

    public void guardarArchivos(List<MultipartFile> multipartFiles) throws IOException {
        for (MultipartFile file : multipartFiles) {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename());
                Files.createDirectories(path.getParent());
                Files.write(path, bytes);
            }
        }
    }
}
