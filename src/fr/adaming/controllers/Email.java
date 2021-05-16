package fr.adaming.controllers;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	public static void sendEmail(String fromMail, String username, String password, String toEmail,
			String subject, String message) throws AddressException, MessagingException {

		// sets SMTP server properties
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.fallback", "false");

		Session mailSession = Session.getDefaultInstance(props, null);
		mailSession.setDebug(true);
		
		Message mailMessage = new MimeMessage(mailSession);
		
		mailMessage.setFrom(new InternetAddress(fromMail));
		mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
		mailMessage.setContent(message, "text/hmtl");
		mailMessage.setSubject(subject);
		
		Transport transport = mailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", username, password);
		
		transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		
	

	}
}
