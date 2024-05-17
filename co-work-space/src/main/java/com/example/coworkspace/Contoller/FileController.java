package com.example.coworkspace.Contoller;

import java.io.IOException;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.coworkspace.Entity.FileEntity;
import com.example.coworkspace.Service.FileService;

@RestController
@CrossOrigin("*")
public class FileController {
	

    @Autowired
    private FileService fileService;

    @PostMapping("/cowork/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            FileEntity savedFile = fileService.saveFile(file);
            return ResponseEntity.ok().body("File uploaded successfully with ID: " + savedFile.getId());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not upload the file: " + e.getMessage());
        }
    }


    @GetMapping("/cowork/download/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long fileId) {
        FileEntity file = fileService.getFile(fileId);
        ByteArrayResource resource = new ByteArrayResource(file.getData());
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(file.getFileType()));
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getFileName()).build());
        
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }

}
