package com.example.coworkspace.Entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FileEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "FileEntity [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", data="
				+ Arrays.toString(data) + ", getId()=" + getId() + ", getFileName()=" + getFileName()
				+ ", getFileType()=" + getFileType() + ", getData()=" + Arrays.toString(getData()) + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public FileEntity(Long id, String fileName, String fileType, byte[] data) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	public FileEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
