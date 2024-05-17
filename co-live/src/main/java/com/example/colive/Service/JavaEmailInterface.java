package com.example.colive.Service;

import javax.mail.MessagingException;

import com.example.colive.Entity.User;
import com.example.colive.Model.EmailRequest;




public interface JavaEmailInterface {


	public String sendSimplEmail(EmailRequest emailRequest) throws MessagingException ;
	public String sendEmaiWithAttachment(EmailRequest emailRequest);
	public String sendSimpleEmailToAdmin(User user);
}
