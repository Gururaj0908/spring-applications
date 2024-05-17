package com.example.coworkspace.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.coworkspace.Entity.User;
import com.example.coworkspace.Model.EmailRequest;


@Service
public class JavaEmailSenderImpl implements JavaEmailInterface {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String sendSimplEmail(EmailRequest emailRequest) {

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setFrom("springbootapplication123@gmail.com");
			helper.setTo(emailRequest.getRecipient());
			helper.setCc(emailRequest.getCc());
			helper.setBcc(emailRequest.getBcc());
			helper.setSubject(emailRequest.getSubject());
			helper.setText(emailRequest.getBody());

			javaMailSender.send(message);

			return "mail sent";

		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error";
		}

	}

	@Override
	public String sendEmaiWithAttachment(EmailRequest emailRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendSimpleEmailToAdmin(User user) {

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setFrom("springbootapplication123@gmail.com");
			helper.setTo("guru.rajkolar1990@gmail.com");
			helper.setSubject(user.getUserFirstName()+"."+user.getUserLastName()+" has been registered");
			helper.setText("Hello Admin, "+user.getUserFirstName()+"."+user.getUserLastName()+" has been registered, below is the details provided: /n Name: "+user.getUserFirstName()+"."+user.getUserLastName());

			javaMailSender.send(message);
                                  
			return "mail sent";

		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error";
		}
	}

	public String sendSimplEmail1(EmailRequest emailRequest) throws MessagingException {
		// TODO Auto-generated method stub
		return null;
	}

	public String sendEmaiWithAttachment1(EmailRequest emailRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public String sendSimpleEmailToAdmin1(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
