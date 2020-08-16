package com.databaseemailmessage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.databaseemailmessage.entity.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Integer> {


}
