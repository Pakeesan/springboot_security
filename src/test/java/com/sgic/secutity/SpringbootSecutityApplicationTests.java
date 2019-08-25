package com.sgic.secutity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sgic.secutity.entity.Task;
import com.sgic.secutity.entity.User;
import com.sgic.secutity.services.TaskService;
import com.sgic.secutity.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSecutityApplicationTests {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private TaskService taskService;
	
	@Before
	public void initDb() {
		{
		User newUser = new User("testUser@gmail.com", "testUser", "123456");
		userservice.createUser(newUser);
	}
	
	{
		User newUser=new User("testAdmin@gmail.com","testUser","123456");
		userservice.createAdmin(newUser);
	}
	
	Task userTask=new Task("25/09/2019", "00:11", "11:00","you need to work today");
	User user=userservice.findOne("testUser@gmail.com");
	taskService.addTask(userTask, user);
	}
	
	
	@Test
	public void testUser() {
		User user=userservice.findOne("testUser@gmail.com");
		
		assertNotNull(user);
		User admin=userservice.findOne("testAdmin@gmail.com");
		assertEquals(admin.getEmail(), "testAdmin@gmail.com");
	}
	
	@Test
	public void testTask() {
		User user =userservice.findOne("testUser@gmail.com");
		List<Task> task=taskService.findUserTask(user);
		assertNotNull(task);
		
	}

}
