package com.example.tkb.Service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    @Value("${file.upload.dir}")
    private String uploadDir;

    public void storeFile(MultipartFile file) throws IOException {
        String filePath = uploadDir + File.separator + file.getOriginalFilename();
        File dest = new File(filePath);
        file.transferTo(dest);
    }
}
