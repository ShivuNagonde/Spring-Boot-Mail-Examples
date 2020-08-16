package com.databaseemailmessage.service;

import com.databaseemailmessage.entity.Worker;

public interface WorkerService {

	public Worker save(Worker worker);
	
    public Worker updateWorker(Worker worker);

	void deleteWorker(int id);

}
