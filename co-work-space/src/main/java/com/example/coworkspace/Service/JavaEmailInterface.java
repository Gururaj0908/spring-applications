package com.example.coworkspace.Service;

import javax.mail.MessagingException;

import com.example.coworkspace.Entity.User;
import com.example.coworkspace.Model.EmailRequest;


public interface JavaEmailInterface {


	public String sendSimplEmail(EmailRequest emailRequest) throws MessagingException ;
	public String sendEmaiWithAttachment(EmailRequest emailRequest);
	public String sendSimpleEmailToAdmin(User user);
}
