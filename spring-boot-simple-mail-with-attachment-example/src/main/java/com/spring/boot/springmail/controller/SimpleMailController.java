package com.spring.boot.springmail.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.springmail.model.Email;

@RestController
@RequestMapping(value = "/email")
public class SimpleMailController {

	@Autowired
	private JavaMailSender sender;
	
	@GetMapping(value = "/sendmail")
	public String sendMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("abc@gmail.com");
		message.setSubject("SpringBootApplication");
		message.setText("Hi, How Are You!");
		sender.send(message);
		
	return "Mail Sent Successful";
	}
	//URL:http://localhost:8088/email/sendMail
	//we must go through email -->My Account(google account) -->Security -->turn on the "less secure app access".
	
	@PostMapping(value = "/sendmail1")
	public String sendMail(@RequestBody Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getTo());
		message.setSubject(email.getMsgSubject());
		message.setText(email.getMsgBody());
		sender.send(message);
		
	return "Mail Sent Successful";
	}
	//URL:http://localhost:8088/email/sendMail1
	
	@PostMapping(value = "/sendMailAttachement")
	public String sendMailAttachement(@RequestBody Email email) throws MessagingException {
		MimeMessage message=sender.createMimeMessage();	
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		helper.setTo(email.getTo());
		helper.setSubject(email.getMsgSubject());
		helper.setText(email.getMsgBody());
		//helper.setText(email.getMsgBody(), true);
		ClassPathResource path=new ClassPathResource("java-logo-wallpaper.png");
		helper.addAttachment("java-logo-wallpaper.png", path);
		sender.send(message);
		return  "Mail Sent Successful";
		}
	//URL:http://localhost:8088/email/sendMailAttachement
}
