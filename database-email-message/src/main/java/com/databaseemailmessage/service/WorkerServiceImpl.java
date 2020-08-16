package com.databaseemailmessage.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.databaseemailmessage.entity.Worker;
import com.databaseemailmessage.repository.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService{

	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@Override
	public Worker save(Worker worker) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("Shivunagonde9999@gmail.com");
		msg.setText("Register Successfully!");
		msg.setSubject("Spring Boot Application");
		sender.send(msg);
		return workerRepository.save(worker);
	}

	@Override
	public Worker updateWorker(Worker worker) {
		 SimpleMailMessage msg = new SimpleMailMessage();
		 msg.setTo("Shivunagonde9999@gmail.com"); 
		 msg.setText("Updated Successfully!");
		 msg.setSubject("Spring Boot Application"); 
		 sender.send(msg);
	     return workerRepository.save(worker);
	}

	@Override
	public void deleteWorker(int id) {
		Optional<Worker> wr = workerRepository.findById(id);
	     if(wr.isPresent()) {
		 SimpleMailMessage msg = new SimpleMailMessage();
		 msg.setTo("Shivunagonde9999@gmail.com"); 
		 msg.setText("Worker id "+id+" Deleted Successfully!");
		 msg.setSubject("Spring Boot Application"); 
		 sender.send(msg);
		 workerRepository.deleteById(id);
		 }
	}
}
