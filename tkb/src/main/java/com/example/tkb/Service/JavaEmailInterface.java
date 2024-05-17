package com.example.tkb.Service;

import javax.mail.MessagingException;

import com.example.tkb.Entity.User;
import com.example.tkb.Model.EmailRequest;




public interface JavaEmailInterface {


	public String sendSimplEmail(EmailRequest emailRequest) throws MessagingException ;
	public String sendEmaiWithAttachment(EmailRequest emailRequest);
	public String sendSimpleEmailToAdmin(User user);
}
