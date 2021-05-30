package com.github.apz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.github.apz.mapper.TaskMapper;
import com.github.apz.model.Task;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class TaskRepository {
	TaskMapper mapper;
	
	public void register(String id) {
		Optional<Integer> count = 
				mapper.findById(id);
		
		if (count.isPresent()) {
			update(id, count.get() +1);
		} else {
			mapper.register(id, 0);
		}
	}
	
	void update(String id, int count) {
		mapper.delete(id);
		mapper.register(id, count);
	}
	
	public List<Task> findAll() {
		return mapper.findAll();
	}
}
