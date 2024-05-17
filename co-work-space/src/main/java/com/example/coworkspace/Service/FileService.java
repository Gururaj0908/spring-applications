package com.example.coworkspace.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.coworkspace.Entity.FileEntity;
import com.example.coworkspace.Repository.FileRepository;

@Service
public class FileService {
	
	@Autowired
	public FileRepository fileRepository;
	
	public FileEntity saveFile(MultipartFile  file) throws IOException {
		
		  String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	        FileEntity fileEntity = new FileEntity();
	        fileEntity.setFileName(fileName);
	        fileEntity.setFileType(file.getContentType());
	        fileEntity.setData(file.getBytes());
	        return fileRepository.save(fileEntity);
	
	}
	
	  public FileEntity getFile(Long fileId) {
	        return fileRepository.findById(fileId)
	                .orElseThrow();
	    }



}
