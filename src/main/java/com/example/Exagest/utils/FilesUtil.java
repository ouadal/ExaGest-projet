package com.example.Exagest.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesUtil {


    public static String saveFile(String fileName, MultipartFile multipartFile, String registrationFolder)
            throws IOException {
        Path uploadPath = Paths.get(registrationFolder);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        //String fileCode = RandomStringUtils.randomAlphanumeric(8);

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            return filePath.toFile().getAbsolutePath();
        } catch (IOException ioe) {
            throw new IOException("Impossible d'enregistrer le fichier: " + fileName, ioe);
        }

    }
}
