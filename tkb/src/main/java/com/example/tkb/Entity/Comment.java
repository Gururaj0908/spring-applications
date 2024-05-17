package com.example.tkb.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	public String content;
	
	public Date createdAt;
	
	public String postedBy;
	
	@ManyToOne
	@JoinColumn(name="newPost_id" , nullable=false)
	public NewPost newpost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public NewPost getNewpost() {
		return newpost;
	}

	public void setNewpost(NewPost newpost) {
		this.newpost = newpost;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", createdAt=" + createdAt + ", postedBy=" + postedBy
				+ ", newpost=" + newpost + ", getId()=" + getId() + ", getContent()=" + getContent()
				+ ", getCreatedAt()=" + getCreatedAt() + ", getPostedBy()=" + getPostedBy() + ", getNewpost()="
				+ getNewpost() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public Comment(Long id, String content, Date createdAt, String postedBy, NewPost newpost) {
		super();
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.postedBy = postedBy;
		this.newpost = newpost;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
 
}
