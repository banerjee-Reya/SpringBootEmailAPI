package com.emailSend.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	public void sendEmail(String toAdress, String emailSubject, String emailBody) {
		MimeMessage createMimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper msg = new MimeMessageHelper(createMimeMessage);
		try {
			
			msg.setTo(toAdress);
			msg.setSubject(emailSubject);
			msg.setText(emailBody);
			
			javaMailSender.send(createMimeMessage);
			System.out.println("SEND");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Not SEND");
		}
		
	}
	
	public void sendDefaultAttachedEmail(String toAdress, String emailSubject, String emailBody){
		MimeMessage message = javaMailSender.createMimeMessage();
			
		try {
			MimeMessageHelper msg = new MimeMessageHelper(message,true);
			ClassPathResource pdf = new ClassPathResource("Questions.pdf"); // path of resources folder
			
			
			msg.setTo(toAdress);
			msg.setSubject(emailSubject);
			msg.setText(emailBody,true);
			
			msg.addAttachment("Questions.pdf", pdf );
//			FileSystemResource file  = new FileSystemResource(new File("C:/Users/reyab/OneDrive/Desktop/Question/Questions.pdf"));
//	        msg.addAttachment("Questions.pdf", file);
			javaMailSender.send(message);
			System.out.println("SEND");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Not SEND");
		}
		
	}
	
	public void sendUploadAttachedEmail(String toAdress, String emailSubject, String emailBody, String path){
		MimeMessage message = javaMailSender.createMimeMessage();
			
		try {
			MimeMessageHelper msg = new MimeMessageHelper(message,true);
			
			
			
			msg.setTo(toAdress);
			msg.setSubject(emailSubject);
			msg.setText(emailBody,true);
			
			//msg.addAttachment("Questions.pdf", pdf );
			FileSystemResource file  = new FileSystemResource(new File(path));
	        msg.addAttachment("Questions.pdf", file);
			javaMailSender.send(message);
			System.out.println("SEND");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Not SEND");
		}
		
	}

}
