package com.starter.springbootmail;

import java.io.IOError;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class SpringBootMailApplication implements CommandLineRunner{

	@Autowired
	private JavaMailSender javaMailSender;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMailApplication.class, args);
	}

	@Override
	public void run(String... args) throws MessagingException,IOError {
		sendEmail();		
	}
private void sendEmail() {
	SimpleMailMessage msg=new SimpleMailMessage();
	msg.setTo("Shivunagonde@gmail.com");
	msg.setSubject("Spring Boot Application");
	msg.setText("Hi,I Like You!");
	System.out.println("sending....");
	javaMailSender.send(msg);
	System.out.println("sent");
}
}
