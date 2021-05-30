package com.github.apz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.apz.model.Task;
import com.github.apz.repository.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {
	
	TaskRepository repository;
	
	public void register(String id) {
		repository.register(id);
	}
	
	public List<Task> taskList() {
		return repository.findAll();
	}
}
