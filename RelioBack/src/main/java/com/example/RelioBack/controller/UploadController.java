package com.example.RelioBack.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Value("${upload.dir}")
    private String uploadDir;

    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("No se ha seleccionado ningún archivo.", HttpStatus.BAD_REQUEST);
        }

        try {
            // Guardar el archivo en el directorio de carga
            String fileName = file.getOriginalFilename();
            System.out.println(uploadDir);
            Path filePath = Paths.get(uploadDir + fileName);
            System.out.println(filePath);
            Files.write(filePath, file.getBytes());

            // Construir la URL del archivo
            String fileUrl = "https://raw.githubusercontent.com/Ajnm98/RelioBack/bb828978d7f16d7505b8dd8f3722f432c48bf847/RelioBack/src/main/resources//photos/" + fileName;

            return new ResponseEntity<>(fileUrl, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error al cargar el archivo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

