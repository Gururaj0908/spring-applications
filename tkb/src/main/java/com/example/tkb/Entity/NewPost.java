package com.example.tkb.Entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class NewPost {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	public String name;
	
	public String content;
	
	public String postedBy;
	
	@Lob
	public byte[] image;
	
	public Date date;
	
	public int likeCount;
	
	public int viewCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "NewPost [id=" + id + ", name=" + name + ", content=" + content + ", postedBy=" + postedBy + ", image="
				+ Arrays.toString(image) + ", date=" + date + ", likeCount=" + likeCount + ", viewCount=" + viewCount
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getContent()=" + getContent()
				+ ", getPostedBy()=" + getPostedBy() + ", getImage()=" + Arrays.toString(getImage()) + ", getDate()="
				+ getDate() + ", getLikeCount()=" + getLikeCount() + ", getViewCount()=" + getViewCount()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public NewPost(Long id, String name, String content, String postedBy, byte[] image, Date date, int likeCount,
			int viewCount) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.postedBy = postedBy;
		this.image = image;
		this.date = date;
		this.likeCount = likeCount;
		this.viewCount = viewCount;
	}

	public NewPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
