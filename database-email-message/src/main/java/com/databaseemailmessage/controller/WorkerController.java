package com.databaseemailmessage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.databaseemailmessage.entity.Worker;
import com.databaseemailmessage.service.WorkerServiceImpl;

@RestController
public class WorkerController {
	
	@Autowired
	private WorkerServiceImpl workerServiceImpl;
	 
	@PostMapping("/save")
	public Worker save(@RequestBody Worker worker) {
		return workerServiceImpl.save(worker);
	}
	@PutMapping("/update/{id}")
	public Worker updateWorkers(@RequestBody Worker worker) {
		return workerServiceImpl.updateWorker(worker);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteWorkers(@PathVariable("id") int id) {
		 workerServiceImpl.deleteWorker(id);
		 return "Worker Deleted Successfully";
	}
}
