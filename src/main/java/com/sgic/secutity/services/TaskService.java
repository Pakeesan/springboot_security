package com.sgic.secutity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.secutity.entity.Task;
import com.sgic.secutity.entity.User;
import com.sgic.secutity.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository tastRepository;
	
	public void addTask(Task task,User user) {
		task.setUser(user);
		tastRepository.save(task);
	}
	public List<Task> findUserTask(User user){
		return tastRepository.findByUser(user);
	}
	
}
