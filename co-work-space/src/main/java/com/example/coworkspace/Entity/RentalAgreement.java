package com.example.coworkspace.Entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class RentalAgreement {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Lob
	    private byte[] file;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public byte[] getFile() {
			return file;
		}

		public void setFile(byte[] file) {
			this.file = file;
		}

		@Override
		public String toString() {
			return "RentalAgreement [id=" + id + ", file=" + Arrays.toString(file) + ", getId()=" + getId()
					+ ", getFile()=" + Arrays.toString(getFile()) + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}

		public RentalAgreement(Long id, byte[] file) {
			super();
			this.id = id;
			this.file = file;
		}

		public RentalAgreement() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
}
