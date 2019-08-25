package com.sgic.secutity.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.secutity.entity.Task;
import com.sgic.secutity.entity.User;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByUser(User user);

}
