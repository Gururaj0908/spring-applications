package com.example.tkb.Model;

public class EmailRequest {

	public String recipient;
	public String cc;
	public String bcc;
	public String subject;
	public String body;
	public String attachment;
	
	
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public EmailRequest(String recipient, String cc,String bcc, String subject, String body, String attachment) {
		super();
		this.recipient = recipient;
		this.cc = cc;
		this.subject = subject;
		this.body = body;
		this.attachment = attachment;
	}
	public EmailRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	}
