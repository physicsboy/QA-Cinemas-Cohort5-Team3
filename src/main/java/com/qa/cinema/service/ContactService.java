package com.qa.cinema.service;

import java.util.Properties;
import com.qa.cinema.persistence.*;

import javax.inject.Inject;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.qa.cinema.util.JSONUtil;


public class ContactService {

    @Inject
    JSONUtil util;
    
    public String getName() {
    	return "";
    }
    
    public String getEmail() {
    	return "";
    }
    
    public String getSubject() {
    	return "";
    }
    
    public String getMessage() {
    	return "";
    }
    
    public String sendEmail(String messageSend) {
    	
    	Email formEmailSend = util.getObjectForJSON(messageSend, Email.class);
    	
    	String username = "qacinemasblue@gmail.com";
    	String password = "anchorage1";
    	String to = "qacinemasblue@gmail.com";
    	
    	Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "465");
		
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
			
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(formEmailSend.getSubject());
			message.setText(formEmailSend.getMessage().toString());
			Transport.send(message);
			System.out.println("message sent");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
		
		return "{\"message\":\" Message Sent \"}";
    }
}